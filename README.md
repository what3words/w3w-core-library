# w3w-core-library 

The what3words core library is a Kotlin multiplatform library that provides API definitions for what3words [data sources](https://github.com/what3words/w3w-core-library/tree/task/MT-6794-Create-README-file-for-Core-Library?tab=readme-ov-file#datasources) and [types](https://github.com/what3words/w3w-core-library/tree/task/MT-6794-Create-README-file-for-Core-Library?tab=readme-ov-file#data-types). It is used across all what3words Android libraries and SDKs.

## DataSources 
A data source provides an API for clients to interact with one or more what3words services using various input and output formats. The what3words core library includes API definitions for the following data sources:

- **W3WTextDataSource**
- **W3WVoiceDataSource**

### 1. W3WTextDataSource
The `W3WTextDataSource` allows clients to interact with what3words core services using text as input. The interface provides APIs for requesting a list of what3words address suggestions based on input text, converting a what3words address to coordinates, and other related functionalities. 

### W3WTextDataSource API Overview

| Method Signature | Return Type                              | Description |
|------------------|------------------------------------------|-------------|
autosuggest(input: String,options: W3WAutosuggestOptions?) | `W3WResult<List<W3WSuggestion>>`         | Get suggestions for a slightly incomplete what3words address.
convertToCoordinates(words: String)  | `W3WResult<W3WAddress>`                  | Convert a what3words address to latitude and longitude.  
convertTo3wa(coordinates: W3WCoordinates, language: W3WLanguage)      | `W3WResult<W3WAddress>`                  | Convert latitude and longitude to a what3words address.
gridSection(boundingBox: W3WRectangle) | `W3WResult<W3WGridSection>`              | Returns a section of the 3m x 3m what3words grid for a bounding box
availableLanguages() | `W3WResult<Set<W3WProprietaryLanguage>>` | Returns a set of all available languages that what3words supports. 
isValid3wa(worrds: String) | `W3WResult<Boolean>`                     | Checks if a what3words address is valid.
version(version: Version) | `String?`                                | Returns the version string for a specified component from `W3WTextDataSource`.


### 2. W3WVoiceDataSource 
The `W3WVoiceDataSource` provides an API that enables clients to extend what3words autosuggest functionality to users through audio input.

### W3WVoiceDataSource API Overview

| Method Signature | Return Type | Description |
|------------------|-------------|-------------|
autosuggest(input: W3WAudioStream, voiceLanguage: W3WLanguage, options: W3WAutosuggestOptions?, onRawResult: ((String) -> Unit)?, onResult: (result: W3WResult<List<W3WSuggestion>>) -> Unit) | `void` |  Performs automatic speech recognition (ASR) on a provided audio stream and returns a list of what3words address suggestions via the `onResult` callback.
availableLanguages() | `W3WResult<Set<W3WProprietaryLanguage>>` | Returns a set of all available what3words languages supported by the current instance of the `W3WVoiceDataSource`.
terminate() | void | Terminates any ongoing autosuggest or speech recognition process and releases associated resources.
version(version: Version) | `String?` | Returns the version string for a specified component from `W3WVoiceDataSource`.

The W3WVoiceDataSource exposes several components that facilitate what3words autosuggestions based on audio inputs:
- **W3WAudioStream**
- **W3WAudioStreamProxy**
- **W3WMicrophone**

#### **W3WAudioStream**
The `W3WAudioStream` is an abstract class that represents an AudioInput source utilized by the `W3WVoiceDataSource` for autosuggest calls. The `W3WVoiceDataSource` implementation is designed to interface with the W3WAudioStream to receive audio signals for automatic speech recognition (ASR) and subsequently conduct what3words autosuggestions based on the ASR output.

Implementations of the `W3WAudioStream` provide event listeners to notify clients of various events, such as changes in listening state, volume adjustments, and errors encountered during the listening process.

#### **W3WAudioStreamProxy** 
The `W3WAudioStreamProxy` serves as a wrapper for the `W3WAudioStream`, allowing implementations of the `W3WVoiceDataSource` to access internal methods and attributes of the `W3WAudioStream`. These include the `openAudioInputStream` and `closeAudioInputStream` methods, as well as the audio stream configuration necessary for setting up the ASR process.

This class is particularly useful for clients seeking to develop their own implementations of a `W3WVoiceDataSource`.

#### **W3WMicrophone**
The `W3WMicrophone` serves as an implementation of a `W3WAudioStream`, connecting to the device's audio framework to capture audio signals. It then delivers these signals to the `W3WVoiceDataSource` for speech recognition purposes.

## Data types
Within the what3words core library, a variety of data types are defined, which are integral to the API of the previously described data sources. These what3words types are broadly categorized into five main groups:
- **Domain** 
- **Geometry**
- **Language** 
- **Options** 
- **Common**

In this section, we will explore some of the essential data types that clients should be familiar with when integrating what3words Android libraries.

#### **Notable types** 
Below are descriptions of some notable what3words data classes with which you should be familiar.
- **W3WAddress:** A `W3WAddress` is a domain type representing a what3words address. It encompasses attributes such as the three words identifying the location, the language of the what3words address, the geocoordinates (latitude and longitude) of the center point of the what3words address, and the nearest place or landmark to the what3words address.
- **W3WSuggestion:** A `W3WSuggestion` is a domain type representing an address suggestion returned from a what3words autosuggest request. It includes the suggested what3words address, the rank or relevance score of the suggestion, and the distance from the suggestion to the focus point if a focus point was set.
- **W3WCoordinates:** This class represents latitude and longitude geographical coordinates within the what3words system. It is utilized to set focus, define lines, circles, polygons, rectangles, and other geometric types within the what3words system.
- **W3WGridSection:** The `W3WGridSection` represents a section of the 3m x 3m what3words grid within a bounding box. It can be effortlessly converted to GeoJSON format using the W3WGridSection.toGeoJSON extension method, facilitating easy display on a map.
- **W3WProprietaryLanguage:** The `W3WProprietaryLanguage` class represents a language utilized within the what3words system, identified by proprietary language codes defined and managed by what3words. It includes attributes describing the language name, its native name, as well as the two-letter code representing the language.
- **W3WRFC5646Language:** In contrast to the `W3WProprietaryLanguage`, the `W3WRFC5646Language` is an enumerated type representing the [RFC5646](https://datatracker.ietf.org/doc/html/rfc5646) definitions for all languages supported by what3words. This class was created to enable clients of the what3words Android libraries to seamlessly utilize an internationally accepted language representation standard when interacting with our APIs, eliminating the need to learn about the proprietary language format used by what3words.

- **W3WAutosuggestOptions:** The W3WAutosuggestOptions class is utilized for refining autosuggestion requests made on any of the public what3words Android libraries. It enables clients to specify clip regions (countries, polygons, circles, etc.) for autosuggestion results. Additionally, it allows clients to specify the number of results to be returned from an autosuggestion request, as well as whether coordinates will be included in the returned address suggestions. Utilize this class to customize the returned what3words address suggestions when making an autosuggestion request in any of our data sources.

## [License](/LICENSE)

``` 
MIT License

Copyright (c) 2024 what3words

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.