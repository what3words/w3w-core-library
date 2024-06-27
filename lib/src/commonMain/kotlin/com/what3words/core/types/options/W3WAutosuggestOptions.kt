package com.what3words.core.types.options

import com.what3words.core.types.domain.W3WCountry
import com.what3words.core.types.geometry.W3WCircle
import com.what3words.core.types.geometry.W3WCoordinates
import com.what3words.core.types.geometry.W3WPolygon
import com.what3words.core.types.geometry.W3WRectangle
import com.what3words.core.types.language.W3WLanguage
import com.what3words.core.types.language.W3WRFC5646Language
import com.what3words.core.types.language.W3WProprietaryLanguage

/**
 * Represents options for fine-tuning autosuggestions request in what3words.
 * This class provides a builder pattern to construct options for autosuggestions.
 * @property focus The focus point for the autosuggestion request.
 * @property language The preferred language for autosuggestions.
 * @property nResults The number of results to return. Defaults to 3.
 * @property nFocusResults The number of results around the focus to return. Defaults to 0.
 * @property clipToCountry A list of [W3WCountry] to clip the autosuggestions to.
 * @property clipToCircle A circle to clip the autosuggestions to.
 * @property clipToBoundingBox A bounding box to clip the autosuggestions to.
 * @property clipToPolygon A polygon to clip the autosuggestions to.
 * @property inputType The input type for autosuggestions.
 * @property preferLand Whether to return only results on land. Defaults to false.
 * @property includeCoordinates Whether each address suggestion returned as part of an autosuggestion request will include coordinates. Defaults to false
 */
class W3WAutosuggestOptions private constructor(
    val focus: W3WCoordinates?,
    val language: W3WLanguage?,
    val nResults: Int,
    val nFocusResults: Int?,
    val clipToCountry: List<W3WCountry>,
    val clipToCircle: W3WCircle?,
    val clipToBoundingBox: W3WRectangle?,
    val clipToPolygon: W3WPolygon?,
    val inputType: W3WAutosuggestInputType?,
    val preferLand: Boolean,
    val includeCoordinates: Boolean
) {
    /**
     * Builder class for creating instances of W3WAutosuggestOptions.
     * Provides methods to set various options for autosuggestions.
     */
    class Builder {
        private var focus: W3WCoordinates? = null
        private var language: W3WLanguage? = null
        private var nResults: Int = 3
        private var nFocusResults: Int? = null
        private var clipToCountry: MutableList<W3WCountry> = mutableListOf()
        private var clipToCircle: W3WCircle? = null
        private var clipToBoundingBox: W3WRectangle? = null
        private var clipToPolygon: W3WPolygon? = null
        private var inputType: W3WAutosuggestInputType? = null
        private var preferLand: Boolean = false
        private var includeCoordinates: Boolean = false

        /**
         * Copies options from an existing W3WAutosuggestOptions instance.
         * @param options The options to copy.
         * @return This builder instance.
         */
        fun fromOptions(options: W3WAutosuggestOptions): Builder {
            focus = options.focus
            language = options.language
            nResults = options.nResults
            nFocusResults = options.nFocusResults
            clipToCountry.addAll(options.clipToCountry)
            clipToCircle = options.clipToCircle
            clipToBoundingBox = options.clipToBoundingBox
            clipToPolygon = options.clipToPolygon
            inputType = options.inputType
            preferLand = options.preferLand
            includeCoordinates = options.includeCoordinates

            return this
        }

        /**
         * Sets the focus point for autosuggestions. This is a location, specified as a latitude (often where the user making the query is).
         * If specified, the results will be weighted to give preference to those near the <code>focus</code>.
         * For convenience, longitude is allowed to wrap around the 180 line, so 361 is equivalent to 1.
         *
         * @param focus The focus point expressed as latitude and longitude coordinates.
         * @return This builder instance.
         */
        fun focus(focus: W3WCoordinates?): Builder {
            this.focus = focus
            return this
        }

        /**
         *  Sets the fallback language for autosuggestions.
         *  For normal text input, specifies a fallback language, which will help guide AutoSuggest if the input is particularly messy.
         *  For voice input (see voice section), language must always be specified.
         *  Accepts instances of [W3WRFC5646Language] or [W3WProprietaryLanguage].
         *
         * @param language The fallback language.
         * @return This builder instance.
         */
        fun language(language: W3WLanguage?): Builder {
            this.language = language
            return this
        }

        /**
         * Sets the number of autosuggest results to return.
         * A maximum of 100 results can be specified, if a number greater than this is requested,
         * this will be truncated to the maximum. The default is 3.
         *
         * @param n The number of AutoSuggest results to return.
         * @return This builder instance.
         */
        fun nResults(n: Int): Builder {
            this.nResults = n
            return this
        }

        /**
         * Specifies the number of results (must be <= nResults) within the results set that will have a focus. By default, it equals nResults.
         * This option allows you to perform autosuggest with a mixture of focused and unfocused results, providing a "blend" of the two. It mirrors the behavior of the old V2 standardblend.
         * You can replicate the behavior of standardblend by setting nFocusResults=1, returning only one focused result and the rest unfocused.
         *
         * @param n The number of AutoSuggest results to return focusing on the provided point.
         * @return This builder instance.
         */
        fun nFocusResults(n: Int): Builder {
            this.nFocusResults = n
            return this
        }

        /**
         * Clips returned suggestions to the specified countries.
         * @param country The countries to clip the autosuggestions to.
         * @return This builder instance.
         */
        fun clipToCountry(vararg country: W3WCountry): Builder {
            this.clipToCountry.addAll(country)
            return this
        }

        /**
         * Restricts returned suggestions to a circular area.
         * For convenience, longitude is allowed to wrap around 180 degrees. For example 181 is equivalent to -179.
         *
         * @param circle The circular area to clip the autosuggestions to.
         * @return This builder instance.
         */
        fun clipToCircle(circle: W3WCircle?): Builder {
            this.clipToCircle = circle
            return this
        }

        /**
         * Restricts autosuggestions to a bounding box.
         *
         * @param boundingBox The bounding box to clip the autosuggestions to.
         * @return This builder instance.
         */
        fun clipToBoundingBox(boundingBox: W3WRectangle?): Builder {
            this.clipToBoundingBox = boundingBox
            return this
        }

        /**
         * Restricts autosuggestions to a polygonal area. The polygon should be closed,
         * i.e. the first element should be repeated as the last element;
         * also the list should contain at least 4 entries.
         * The API is currently limited to accepting up to 25 pairs.
         *
         * @param polygon The polygonal area to clip the autosuggestions to.
         * @return This builder instance.
         */
        fun clipToPolygon(polygon: W3WPolygon): Builder {
            this.clipToPolygon = polygon
            return this
        }

        /**
         * Sets the input type for autosuggestions. For power users, used to specify voice input mode.
         * Can be <code>AutosuggestInputType.TEXT</code> (default), <code>AutosuggestInputType.VOCON_HYBRID</code> or <code>AutosuggestInputType.NMDP_ASR</code>.
         * See voice recognition section within the [developer docs](https://docs.what3words.com/api/v3/#voice) for more details.
         *
         * @param inputType The input type for autosuggestions.
         * @return This builder instance.
         */
        fun inputType(inputType: W3WAutosuggestInputType): Builder {
            this.inputType = inputType
            return this
        }

        /**
         * Sets whether to prefer land-based suggestions.
         * @param preferLand Whether to prefer land-based suggestions.
         * @return This builder instance.
         */
        fun preferLand(preferLand: Boolean): Builder {
            this.preferLand = preferLand
            return this
        }

        /**
         *  Sets whether to include coordinates for each address suggestion returned as part of an autosuggestion request.
         *
         *  @param include If true, each address suggestion will include coordinates. If false, they will not.
         *  @return This builder instance.
         */
        fun includeCoordinates(include: Boolean): Builder {
            this.includeCoordinates = include
            return this
        }

        /**
         * Builds and returns a new instance of W3WAutosuggestOptions using the provided configuration.
         *
         * @return A new instance of W3WAutosuggestOptions with the specified options.
         */
        fun build(): W3WAutosuggestOptions {
            return W3WAutosuggestOptions(
                focus = focus,
                language = language,
                nResults = nResults,
                nFocusResults = nFocusResults,
                clipToCountry = clipToCountry,
                clipToCircle = clipToCircle,
                clipToBoundingBox = clipToBoundingBox,
                clipToPolygon = clipToPolygon,
                inputType = inputType,
                preferLand = preferLand,
                includeCoordinates = includeCoordinates
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as W3WAutosuggestOptions

        if (focus != other.focus) return false
        if (language != other.language) return false
        if (nResults != other.nResults) return false
        if (nFocusResults != other.nFocusResults) return false
        if (clipToCountry != other.clipToCountry) return false
        if (clipToCircle != other.clipToCircle) return false
        if (clipToBoundingBox != other.clipToBoundingBox) return false
        if (clipToPolygon != other.clipToPolygon) return false
        if (inputType != other.inputType) return false
        if (preferLand != other.preferLand) return false
        if (includeCoordinates != other.includeCoordinates) return false

        return true
    }

    override fun hashCode(): Int {
        var result = focus?.hashCode() ?: 0
        result = 31 * result + (language?.hashCode() ?: 0)
        result = 31 * result + nResults
        result = 31 * result + (nFocusResults ?: 0)
        result = 31 * result + clipToCountry.hashCode()
        result = 31 * result + (clipToCircle?.hashCode() ?: 0)
        result = 31 * result + (clipToBoundingBox?.hashCode() ?: 0)
        result = 31 * result + (clipToPolygon?.hashCode() ?: 0)
        result = 31 * result + (inputType?.hashCode() ?: 0)
        result = 31 * result + preferLand.hashCode()
        result = 31 * result + includeCoordinates.hashCode()

        return result
    }

    override fun toString(): String {
        return "W3WAutosuggestOptions(focus=$focus, language=$language, nResults=$nResults, nFocusResults=$nFocusResults, clipToCountry=$clipToCountry, clipToCircle=$clipToCircle, clipToBoundingBox=$clipToBoundingBox, clipToPolygon=$clipToPolygon, inputType=$inputType, preferLand=$preferLand, includeCoordinates=$includeCoordinates)"
    }

}
