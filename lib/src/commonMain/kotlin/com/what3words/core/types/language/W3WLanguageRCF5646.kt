package com.what3words.core.types.language

/**
 * Enumeration representing [RFC5646](https://datatracker.ietf.org/doc/html/rfc5646) definitions for all what3words supported languages
 */
enum class W3WLanguageRCF5646(val code: String) {
    AF(code = "af"),
    AM(code = "am"),
    AR(code = "ar"),
    BG(code = "bg"),
    BN(code = "bn"),
    BS_LATN(code = "bs-Latn"),
    BS_CYRL(code = "bs-Cyrl"),
    CA(code = "ca"),
    CS(code = "cs"),
    CY(code = "cy"),
    DA(code = "da"),
    DE(code = "de"),
    EL(code = "el"),
    EN_AU(code = "en-AU"),
    EN_CA(code = "en-CA"),
    EN_GB(code = "en-GB"),
    EN_IN(code = "en-IN"),
    EN_US(code = "en-US"),
    ES_ES(code = "es-ES"),
    ES_MX(code = "es-MX"),
    ET(code = "et"),
    FA(code = "fa"),
    FI(code = "fi"),
    FR_CA(code = "fr-CA"),
    FR_FR(code = "fr-FR"),
    GU(code = "gu"),
    HE(code = "he"),
    HI(code = "hi"),
    HR(code = "hr"),
    HU(code = "hu"),
    ID(code = "id"),
    IT(code = "it"),
    JA(code = "ja"),
    KK_CYRL(code = "kk-Cyrl"),
    KK_LATN(code = "kk-Latn"),
    KM(code = "km"),
    KN(code = "kn"),
    KO(code = "ko"),
    LO(code = "lo"),
    ML(code = "ml"),
    MN_CYRL(code = "mn-Cyrl"),
    MN_LATN(code = "mn-Latn"),
    MR(code = "mr"),
    MS(code = "ms"),
    NE(code = "ne"),
    NL(code = "nl"),
    NO(code = "no"),
    OR(code = "or"),
    PA(code = "pa"),
    PL(code = "pl"),
    PT_BR(code = "pt-BR"),
    PT_PT(code = "pt-PT"),
    RO(code = "ro"),
    RU(code = "ru"),
    SI(code = "si"),
    SK(code = "sk"),
    SR_LATN_RS(code = "sr-Latn-RS"),
    SR_CYRL_RS(code = "sr-Cyrl-RS"),
    SR_LATN_ME(code = "sr-Latn-ME"),
    SR_CYRL_ME(code = "sr-Cyrl-ME"),
    SV(code = "sv"),
    SW(code = "sw"),
    TA(code = "ta"),
    TE(code = "te"),
    TH(code = "th"),
    TR(code = "tr"),
    UK(code = "uk"),
    UR(code = "ur"),
    VI(code = "vi"),
    XH(code = "xh"),
    ZH_HANS(code = "zh-Hans"),
    ZH_HANT_HK(code = "zh-Hant-HK"),
    ZH_HANT_TW(code = "zh-Hant-TW"),
    ZU(code = "zu");

    /**
     * Retrieves the RFC5646 language ISO 639-1 code.
     * Example: [W3WLanguageRCF5646.ZH_HANT_TW.getLanguageCode] returns "zh".
     *
     * @return Language ISO 639-1 two-letter code.
     */
    fun getLanguageCode(): String {
        return code.split("-")[0]
    }


    /**
     * Retrieves the RFC5646 script ISO 15924 code.
     * Example: [W3WLanguageRCF5646.ZH_HANT_TW.getScriptCode] returns "Hant".
     *
     * @return Script ISO 15924 four-letter code, or null if not applicable.
     */
    fun getScriptCode(): String? {
        val split = code.split("-")
        return when {
            split.size == 2 && split[1].count() == 4 -> split[1]
            split.size == 3 && split[1].count() == 4 -> split[1]
            else -> null
        }
    }

    /**
     * Retrieves the RFC5646 region ISO 3166-1 alpha-2 code.
     * Example: [W3WLanguageRCF5646.ZH_HANT_TW.getRegionCode] returns "TW".
     *
     * @return Region ISO 3166-1 alpha-2 two-letter code, or null if not applicable.
     */
    fun getRegionCode(): String? {
        val split = code.split("-")
        return when {
            split.size == 2 && split[1].count() == 2 -> split[1]
            split.size == 3 && split[2].count() == 2 -> split[2]
            else -> null
        }
    }
}