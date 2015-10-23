// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace Fixtures.AcceptanceTestsHttp.Models
{
    using System;
    using System.Linq;
    using System.Collections.Generic;
    using Newtonsoft.Json;
    using Microsoft.Rest;
    using Microsoft.Rest.Serialization;

    /// <summary>
    /// </summary>
    public partial class B : A
    {
        /// <summary>
        /// Initializes a new instance of the B class.
        /// </summary>
        public B() { }

        /// <summary>
        /// Initializes a new instance of the B class.
        /// </summary>
        public B(string textStatusCode = default(string))
        {
            TextStatusCode = textStatusCode;
        }

        /// <summary>
        /// </summary>
        [JsonProperty(PropertyName = "textStatusCode")]
        public string TextStatusCode { get; set; }

    }
}
