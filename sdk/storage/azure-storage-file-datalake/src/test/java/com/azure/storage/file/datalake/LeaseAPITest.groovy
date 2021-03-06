// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.file.datalake

import com.azure.core.http.RequestConditions
import com.azure.storage.blob.models.BlobStorageException
import com.azure.storage.file.datalake.models.LeaseDurationType
import com.azure.storage.file.datalake.models.LeaseStateType
import spock.lang.Unroll

class LeaseAPITest extends APISpec {
    private DataLakeFileClient createPathClient() {
        def fc = fsc.getFileClient(generatePathName())
        fc.create()
        return fc
    }

    @Unroll
    def "Acquire file lease"() {
        setup:
        def fc = createPathClient()
        def leaseClient = createLeaseClient(fc, proposedID)

        when:
        def leaseId = leaseClient.acquireLease(leaseTime)

        then:
        leaseId != null

        when:
        def response = fc.getPropertiesWithResponse(null, null, null)
        def properties = response.getValue()
        def headers = response.getHeaders()

        then:
        properties.getLeaseState() == leaseState
        properties.getLeaseDuration() == leaseDuration
        validateBasicHeaders(headers)

        where:
        proposedID                   | leaseTime || leaseState            | leaseDuration
        null                         | -1        || LeaseStateType.LEASED | LeaseDurationType.INFINITE
        null                         | 25        || LeaseStateType.LEASED | LeaseDurationType.FIXED
        UUID.randomUUID().toString() | -1        || LeaseStateType.LEASED | LeaseDurationType.INFINITE
    }

    def "Acquire file lease min"() {
        expect:
        createLeaseClient(createPathClient())
            .acquireLeaseWithResponse(-1, null, null, null)
            .getStatusCode() == 201
    }

    @Unroll
    def "Acquire file lease duration fail"() {
        setup:
        def leaseClient = createLeaseClient(createPathClient())

        when:
        leaseClient.acquireLease(duration)

        then:
        thrown(BlobStorageException)

        where:
        duration | _
        -10      | _
        10       | _
        70       | _
    }

    @Unroll
    def "Acquire file lease AC"() {
        setup:
        def fc = createPathClient()
        match = setupPathMatchCondition(fc, match)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        expect:
        createLeaseClient(fc)
            .acquireLeaseWithResponse(-1, mac, null, null)
            .getStatusCode() == 201

        where:
        modified | unmodified | match        | noneMatch
        null     | null       | null         | null
        oldDate  | null       | null         | null
        null     | newDate    | null         | null
        null     | null       | receivedEtag | null
        null     | null       | null         | garbageEtag
    }

    @Unroll
    def "Acquire file lease AC fail"() {
        setup:
        def fc = createPathClient()
        noneMatch = setupPathMatchCondition(fc, noneMatch)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fc).acquireLeaseWithResponse(-1, mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified | match       | noneMatch
        newDate  | null       | null        | null
        null     | oldDate    | null        | null
        null     | null       | garbageEtag | null
        null     | null       | null        | receivedEtag
    }

    def "Acquire file lease error"() {
        setup:
        def fc = fsc.getFileClient(generatePathName())

        when:
        createLeaseClient(fc).acquireLease(20)

        then:
        thrown(BlobStorageException)
    }

    def "Renew file lease"() {
        setup:
        def fc = createPathClient()
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)

        // If running in live mode wait for the lease to expire to ensure we are actually renewing it
        sleepIfRecord(16000)
        def renewLeaseResponse = createLeaseClient(fc, leaseID).renewLeaseWithResponse(null, null, null)

        expect:
        fc.getProperties().getLeaseState() == LeaseStateType.LEASED
        validateBasicHeaders(renewLeaseResponse.getHeaders())
        renewLeaseResponse.getValue() != null
    }

    def "Renew file lease min"() {
        setup:
        def fc = createPathClient()
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)

        expect:
        createLeaseClient(fc, leaseID)
            .renewLeaseWithResponse(null, null, null)
            .getStatusCode() == 200
    }

    @Unroll
    def "Renew file lease AC"() {
        setup:
        def fc = createPathClient()
        match = setupPathMatchCondition(fc, match)
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        expect:
        createLeaseClient(fc, leaseID)
            .renewLeaseWithResponse(mac, null, null)
            .getStatusCode() == 200

        where:
        modified | unmodified | match        | noneMatch
        null     | null       | null         | null
        oldDate  | null       | null         | null
        null     | newDate    | null         | null
        null     | null       | receivedEtag | null
        null     | null       | null         | garbageEtag
    }

    @Unroll
    def "Renew file lease AC fail"() {
        setup:
        def fc = createPathClient()
        noneMatch = setupPathMatchCondition(fc, noneMatch)
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fc, leaseID).renewLeaseWithResponse(mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified | match       | noneMatch
        newDate  | null       | null        | null
        null     | oldDate    | null        | null
        null     | null       | garbageEtag | null
        null     | null       | null        | receivedEtag
    }

    def "Renew file lease error"() {
        setup:
        def fc = fsc.getFileClient(generatePathName())

        when:
        createLeaseClient(fc, "id").renewLease()

        then:
        thrown(BlobStorageException)
    }

    def "Release file lease"() {
        setup:
        def fc = createPathClient()
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def headers = createLeaseClient(fc, leaseID).releaseLeaseWithResponse(null, null, null).getHeaders()

        expect:
        fc.getProperties().getLeaseState() == LeaseStateType.AVAILABLE
        validateBasicHeaders(headers)
    }

    def "Release file lease min"() {
        setup:
        def fc = createPathClient()
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)

        expect:
        createLeaseClient(fc, leaseID).releaseLeaseWithResponse(null, null, null).getStatusCode() == 200
    }

    @Unroll
    def "Release file lease AC"() {
        setup:
        def fc = createPathClient()
        match = setupPathMatchCondition(fc, match)
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        expect:
        createLeaseClient(fc, leaseID).releaseLeaseWithResponse(mac, null, null).getStatusCode() == 200

        where:
        modified | unmodified | match        | noneMatch
        null     | null       | null         | null
        oldDate  | null       | null         | null
        null     | newDate    | null         | null
        null     | null       | receivedEtag | null
        null     | null       | null         | garbageEtag
    }

    @Unroll
    def "Release file lease AC fail"() {
        setup:
        def fc = createPathClient()
        noneMatch = setupPathMatchCondition(fc, noneMatch)
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fc, leaseID).releaseLeaseWithResponse(mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified | match       | noneMatch
        newDate  | null       | null        | null
        null     | oldDate    | null        | null
        null     | null       | garbageEtag | null
        null     | null       | null        | receivedEtag
    }

    def "Release file lease error"() {
        setup:
        def fc = fsc.getFileClient(generatePathName())

        when:
        createLeaseClient(fc, "id").releaseLease()

        then:
        thrown(BlobStorageException)
    }

    @Unroll
    def "Break file lease"() {
        setup:
        def fc = createPathClient()
        def leaseClient = createLeaseClient(fc, getRandomUUID())

        when:
        leaseClient.acquireLease(leaseTime)
        def breakLeaseResponse = leaseClient.breakLeaseWithResponse(breakPeriod, null, null, null)
        def leaseState = fc.getProperties().getLeaseState()

        then:
        leaseState == LeaseStateType.BROKEN || leaseState == LeaseStateType.BREAKING
        breakLeaseResponse.getValue() <= remainingTime
        validateBasicHeaders(breakLeaseResponse.getHeaders())

        where:
        leaseTime | breakPeriod | remainingTime
        -1        | null        | 0
        -1        | 20          | 25
        20        | 15          | 16
    }

    def "Break file lease min"() {
        setup:
        def fc = createPathClient()
        setupPathLeaseCondition(fc, receivedLeaseID)

        expect:
        createLeaseClient(fc).breakLeaseWithResponse(null, null, null, null).getStatusCode() == 202
    }

    @Unroll
    def "Break file lease AC"() {
        setup:
        def fc = createPathClient()
        match = setupPathMatchCondition(fc, match)
        setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        expect:
        createLeaseClient(fc).breakLeaseWithResponse(null, mac, null, null).getStatusCode() == 202

        where:
        modified | unmodified | match        | noneMatch
        null     | null       | null         | null
        oldDate  | null       | null         | null
        null     | newDate    | null         | null
        null     | null       | receivedEtag | null
        null     | null       | null         | garbageEtag
    }

    @Unroll
    def "Break file lease AC fail"() {
        setup:
        def fc = createPathClient()
        noneMatch = setupPathMatchCondition(fc, noneMatch)
        setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fc).breakLeaseWithResponse(null, mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified | match       | noneMatch
        newDate  | null       | null        | null
        null     | oldDate    | null        | null
        null     | null       | garbageEtag | null
        null     | null       | null        | receivedEtag
    }

    def "Break file lease error"() {
        setup:
        def fc = createPathClient()

        when:
        createLeaseClient(fc).breakLease()

        then:
        thrown(BlobStorageException)
    }

    def "Change file lease"() {
        setup:
        def fc = createPathClient()
        def leaseClient = createLeaseClient(fc, getRandomUUID())
        leaseClient.acquireLease(15)
        def changeLeaseResponse = leaseClient.changeLeaseWithResponse(getRandomUUID(), null, null, null)
        def leaseClient2 = createLeaseClient(fc, changeLeaseResponse.getValue())

        expect:
        leaseClient2.releaseLeaseWithResponse(null, null, null).getStatusCode() == 200
        validateBasicHeaders(changeLeaseResponse.getHeaders())
    }

    def "Change file lease min"() {
        setup:
        def fc = createPathClient()
        def leaseID = setupPathLeaseCondition(fc, receivedLeaseID)

        expect:
        createLeaseClient(fc, leaseID).changeLeaseWithResponse(getRandomUUID(), null, null, null).getStatusCode() == 200
    }

    @Unroll
    def "Change file lease AC"() {
        setup:
        def fc = createPathClient()
        match = setupPathMatchCondition(fc, match)
        String leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        expect:
        createLeaseClient(fc, leaseID).changeLeaseWithResponse(getRandomUUID(), mac, null, null).getStatusCode() == 200

        where:
        modified | unmodified | match        | noneMatch
        null     | null       | null         | null
        oldDate  | null       | null         | null
        null     | newDate    | null         | null
        null     | null       | receivedEtag | null
        null     | null       | null         | garbageEtag
    }

    @Unroll
    def "Change file lease AC fail"() {
        setup:
        def fc = createPathClient()
        noneMatch = setupPathMatchCondition(fc, noneMatch)
        String leaseID = setupPathLeaseCondition(fc, receivedLeaseID)
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fc, leaseID).changeLeaseWithResponse(getRandomUUID(), mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified | match       | noneMatch
        newDate  | null       | null        | null
        null     | oldDate    | null        | null
        null     | null       | garbageEtag | null
        null     | null       | null        | receivedEtag
    }

    def "Change file lease error"() {
        setup:
        def fc = fsc.getFileClient(generatePathName())

        when:
        createLeaseClient(fc, "id").changeLease("id")

        then:
        thrown(BlobStorageException)
    }


    @Unroll
    def "Acquire file system lease"() {
        setup:
        def leaseResponse = createLeaseClient(fsc, proposedID).acquireLeaseWithResponse(leaseTime, null, null, null)

        when:
        def properties = fsc.getProperties()

        then:
        leaseResponse.getValue() != null
        validateBasicHeaders(leaseResponse.getHeaders())
        properties.getLeaseState() == leaseState
        properties.getLeaseDuration() == leaseDuration

        where:
        proposedID                   | leaseTime || leaseState            | leaseDuration
        null                         | -1        || LeaseStateType.LEASED | LeaseDurationType.INFINITE
        null                         | 25        || LeaseStateType.LEASED | LeaseDurationType.FIXED
        UUID.randomUUID().toString() | -1        || LeaseStateType.LEASED | LeaseDurationType.INFINITE
    }

    def "Acquire file system lease min"() {
        expect:
        createLeaseClient(fsc).acquireLeaseWithResponse(-1, null, null, null).getStatusCode() == 201
    }

    @Unroll
    def "Acquire file system lease duration fail"() {
        setup:
        def leaseClient = createLeaseClient(fsc)

        when:
        leaseClient.acquireLease(duration)

        then:
        thrown(BlobStorageException)

        where:
        duration | _
        -10      | _
        10       | _
        70       | _
    }

    @Unroll
    def "Acquire file system lease AC"() {
        setup:
        def mac = new RequestConditions()
            .setIfModifiedSince(modified)
            .setIfUnmodifiedSince(unmodified)
            .setIfMatch(match)
            .setIfNoneMatch(noneMatch)

        expect:
        createLeaseClient(fsc).acquireLeaseWithResponse(-1, mac, null, null).getStatusCode() == 201

        where:
        modified | unmodified | match        | noneMatch
        null     | null       | null         | null
        oldDate  | null       | null         | null
        null     | newDate    | null         | null
        null     | null       | receivedEtag | null
        null     | null       | null         | garbageEtag
    }

    @Unroll
    def "Acquire file system lease AC fail"() {
        setup:
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        when:
        createLeaseClient(fsc).acquireLeaseWithResponse(-1, mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified
        newDate  | null
        null     | oldDate
    }

    def "Acquire file system lease error"() {
        setup:
        fsc = primaryDataLakeServiceClient.getFileSystemClient(generateFileSystemName())

        when:
        createLeaseClient(fsc).acquireLease(50)

        then:
        thrown(BlobStorageException)
    }

    def "Renew file system lease"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)

        // If running in live mode wait for the lease to expire to ensure we are actually renewing it
        sleepIfRecord(16000)
        def renewLeaseResponse = createLeaseClient(fsc, leaseID).renewLeaseWithResponse(null, null, null)

        expect:
        fsc.getProperties().getLeaseState() == LeaseStateType.LEASED
        validateBasicHeaders(renewLeaseResponse.getHeaders())
    }

    def "Renew file system lease min"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)

        expect:
        createLeaseClient(fsc, leaseID).renewLeaseWithResponse(null, null, null).getStatusCode() == 200
    }

    @Unroll
    def "Renew file system lease AC"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        expect:
        createLeaseClient(fsc, leaseID).renewLeaseWithResponse(mac, null, null).getStatusCode() == 200

        where:
        modified | unmodified
        null     | null
        oldDate  | null
        null     | newDate
    }

    @Unroll
    def "Renew file system lease AC fail"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        when:
        createLeaseClient(fsc, leaseID).renewLeaseWithResponse(mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified
        newDate  | null
        null     | oldDate
    }

    @Unroll
    def "Renew file system lease AC illegal"() {
        setup:
        def mac = new RequestConditions().setIfMatch(match).setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fsc, receivedEtag).renewLeaseWithResponse(mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        match        | noneMatch
        receivedEtag | null
        null         | garbageEtag
    }

    def "Renew file system lease error"() {
        setup:
        fsc = primaryDataLakeServiceClient.getFileSystemClient(generateFileSystemName())

        when:
        createLeaseClient(fsc, "id").renewLease()

        then:
        thrown(BlobStorageException)
    }

    def "Release file system lease"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)

        def releaseLeaseResponse = createLeaseClient(fsc, leaseID).releaseLeaseWithResponse(null, null, null)

        expect:
        fsc.getProperties().getLeaseState() == LeaseStateType.AVAILABLE
        validateBasicHeaders(releaseLeaseResponse.getHeaders())
    }

    def "Release file system lease min"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)

        expect:
        createLeaseClient(fsc, leaseID).releaseLeaseWithResponse(null, null, null).getStatusCode() == 200
    }

    @Unroll
    def "Release file system lease AC"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        expect:
        createLeaseClient(fsc, leaseID).releaseLeaseWithResponse(mac, null, null).getStatusCode() == 200

        where:
        modified | unmodified
        null     | null
        oldDate  | null
        null     | newDate
    }

    @Unroll
    def "Release file system lease AC fail"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        when:
        createLeaseClient(fsc, leaseID).releaseLeaseWithResponse(mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified
        newDate  | null
        null     | oldDate
    }

    @Unroll
    def "Release file system lease AC illegal"() {
        setup:
        def mac = new RequestConditions().setIfMatch(match).setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fsc, receivedLeaseID).releaseLeaseWithResponse(mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        match        | noneMatch
        receivedEtag | null
        null         | garbageEtag
    }

    def "Release file system lease error"() {
        setup:
        fsc = primaryDataLakeServiceClient.getFileSystemClient(generateFileSystemName())

        when:
        createLeaseClient(fsc, "id").releaseLease()

        then:
        thrown(BlobStorageException)
    }

    @Unroll
    def "Break file system lease"() {
        setup:
        def leaseClient = createLeaseClient(fsc, getRandomUUID())
        leaseClient.acquireLease(leaseTime)

        def breakLeaseResponse = leaseClient.breakLeaseWithResponse(breakPeriod, null, null, null)
        def state = fsc.getProperties().getLeaseState()

        expect:
        state == LeaseStateType.BROKEN || state == LeaseStateType.BREAKING
        breakLeaseResponse.getValue() <= remainingTime
        validateBasicHeaders(breakLeaseResponse.getHeaders())
        if (breakPeriod != null) {
            // If running in live mode wait for the lease to break so we can delete the file system after the test completes
            sleepIfRecord(breakPeriod * 1000)
        }

        where:
        leaseTime | breakPeriod | remainingTime
        -1        | null        | 0
        -1        | 20          | 25
        20        | 15          | 16

    }

    def "Break file system lease min"() {
        setup:
        setupFileSystemLeaseCondition(fsc, receivedLeaseID)

        expect:
        createLeaseClient(fsc).breakLeaseWithResponse(null, null, null, null).getStatusCode() == 202
    }

    @Unroll
    def "Break file system lease AC"() {
        setup:
        setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        expect:
        createLeaseClient(fsc).breakLeaseWithResponse(null, mac, null, null).getStatusCode() == 202

        where:
        modified | unmodified
        null     | null
        oldDate  | null
        null     | newDate
    }

    @Unroll
    def "Break file system lease AC fail"() {
        setup:
        setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        when:
        createLeaseClient(fsc).breakLeaseWithResponse(null, mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified
        newDate  | null
        null     | oldDate
    }

    @Unroll
    def "Break file system lease AC illegal"() {
        setup:
        def mac = new RequestConditions().setIfMatch(match).setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fsc).breakLeaseWithResponse(null, mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        match        | noneMatch
        receivedEtag | null
        null         | garbageEtag
    }

    def "Break file system lease error"() {
        setup:
        fsc = primaryDataLakeServiceClient.getFileSystemClient(generateFileSystemName())

        when:
        createLeaseClient(fsc).breakLease()

        then:
        thrown(BlobStorageException)
    }

    def "Change file system lease"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def leaseClient = createLeaseClient(fsc, leaseID)
        def changeLeaseResponse = leaseClient.changeLeaseWithResponse(getRandomUUID(), null, null, null)
        leaseID = changeLeaseResponse.getValue()

        expect:
        createLeaseClient(fsc, leaseID).releaseLeaseWithResponse(null, null, null).getStatusCode() == 200
        validateBasicHeaders(changeLeaseResponse.getHeaders())
    }

    def "Change file system lease min"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)

        expect:
        createLeaseClient(fsc, leaseID).changeLeaseWithResponse(getRandomUUID(), null, null, null).getStatusCode() == 200
    }

    @Unroll
    def "Change file system lease AC"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        expect:
        createLeaseClient(fsc, leaseID).changeLeaseWithResponse(getRandomUUID(), mac, null, null).getStatusCode() == 200

        where:
        modified | unmodified
        null     | null
        oldDate  | null
        null     | newDate
    }

    @Unroll
    def "Change file system lease AC fail"() {
        setup:
        def leaseID = setupFileSystemLeaseCondition(fsc, receivedLeaseID)
        def mac = new RequestConditions().setIfModifiedSince(modified).setIfUnmodifiedSince(unmodified)

        when:
        createLeaseClient(fsc, leaseID).changeLeaseWithResponse(getRandomUUID(), mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        modified | unmodified
        newDate  | null
        null     | oldDate
    }

    @Unroll
    def "Change file system lease AC illegal"() {
        setup:
        def mac = new RequestConditions().setIfMatch(match).setIfNoneMatch(noneMatch)

        when:
        createLeaseClient(fsc, receivedLeaseID).changeLeaseWithResponse(garbageLeaseID, mac, null, null)

        then:
        thrown(BlobStorageException)

        where:
        match        | noneMatch
        receivedEtag | null
        null         | garbageEtag
    }

    def "Change file system lease error"() {
        setup:
        fsc = primaryDataLakeServiceClient.getFileSystemClient(generateFileSystemName())

        when:
        createLeaseClient(fsc, "id").changeLease("id")

        then:
        thrown(BlobStorageException)
    }
}
