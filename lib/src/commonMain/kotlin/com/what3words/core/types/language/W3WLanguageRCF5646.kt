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

    fun toW3WLanguage(): W3WLanguage {
        return when (this) {
            AF -> W3WLanguage(code = "af", locale = null)
            AM -> W3WLanguage(code = "am", locale = null)
            AR -> W3WLanguage(code = "ar", locale = null)
            BG -> W3WLanguage(code = "bg", locale = null)
            BN -> W3WLanguage(code = "bn", locale = null)
            BS_LATN -> W3WLanguage(code = "oo", locale = "oo_la")
            BS_CYRL -> W3WLanguage(code = "oo", locale = "oo_cy")
            CA -> W3WLanguage(code = "ca", locale = null)
            CS -> W3WLanguage(code = "cs", locale = null)
            CY -> W3WLanguage(code = "cy", locale = null)
            DA -> W3WLanguage(code = "da", locale = null)
            DE -> W3WLanguage(code = "de", locale = null)
            EL -> W3WLanguage(code = "el", locale = null)
            EN_AU -> W3WLanguage(code = "en", locale = null)
            EN_CA -> W3WLanguage(code = "en", locale = null)
            EN_GB -> W3WLanguage(code = "en", locale = null)
            EN_IN -> W3WLanguage(code = "en", locale = null)
            EN_US -> W3WLanguage(code = "en", locale = null)
            ES_ES -> W3WLanguage(code = "es", locale = null)
            ES_MX -> W3WLanguage(code = "es", locale = null)
            ET -> W3WLanguage(code = "et", locale = null)
            FA -> W3WLanguage(code = "fa", locale = null)
            FI -> W3WLanguage(code = "fi", locale = null)
            FR_CA -> W3WLanguage(code = "fr", locale = null)
            FR_FR -> W3WLanguage(code = "fr", locale = null)
            GU -> W3WLanguage(code = "gu", locale = null)
            HE -> W3WLanguage(code = "he", locale = null)
            HI -> W3WLanguage(code = "hi", locale = null)
            HR -> W3WLanguage(code = "hr", locale = null)
            HU -> W3WLanguage(code = "hu", locale = null)
            ID -> W3WLanguage(code = "id", locale = null)
            IT -> W3WLanguage(code = "it", locale = null)
            JA -> W3WLanguage(code = "ja", locale = null)
            KK_CYRL -> W3WLanguage(code = "kk", locale = "kk_cy")
            KK_LATN -> W3WLanguage(code = "kk", locale = "kk_la")
            KM -> W3WLanguage(code = "km", locale = null)
            KN -> W3WLanguage(code = "kn", locale = null)
            KO -> W3WLanguage(code = "ko", locale = null)
            LO -> W3WLanguage(code = "lo", locale = null)
            ML -> W3WLanguage(code = "ml", locale = null)
            MN_CYRL -> W3WLanguage(code = "mn", locale = "mn_cy")
            MN_LATN -> W3WLanguage(code = "mn", locale = "mn_la")
            MR -> W3WLanguage(code = "mr", locale = null)
            MS -> W3WLanguage(code = "ms", locale = null)
            NE -> W3WLanguage(code = "ns", locale = null)
            NL -> W3WLanguage(code = "nl", locale = null)
            NO -> W3WLanguage(code = "no", locale = null)
            OR -> W3WLanguage(code = "or", locale = null)
            PA -> W3WLanguage(code = "pa", locale = null)
            PL -> W3WLanguage(code = "pl", locale = null)
            PT_BR -> W3WLanguage(code = "pt", locale = null)
            PT_PT -> W3WLanguage(code = "pt", locale = null)
            RO -> W3WLanguage(code = "ro", locale = null)
            RU -> W3WLanguage(code = "ru", locale = null)
            SI -> W3WLanguage(code = "si", locale = null)
            SK -> W3WLanguage(code = "sk", locale = null)
            SR_LATN_RS -> W3WLanguage(code = "oo", locale = "oo_la")
            SR_CYRL_RS -> W3WLanguage(code = "oo", locale = "oo_cy")
            SR_LATN_ME -> W3WLanguage(code = "oo", locale = "oo_la")
            SR_CYRL_ME -> W3WLanguage(code = "oo", locale = "oo_cy")
            SV -> W3WLanguage(code = "sv", locale = null)
            SW -> W3WLanguage(code = "sw", locale = null)
            TA -> W3WLanguage(code = "ta", locale = null)
            TE -> W3WLanguage(code = "te", locale = null)
            TH -> W3WLanguage(code = "th", locale = null)
            TR -> W3WLanguage(code = "tr", locale = null)
            UK -> W3WLanguage(code = "uk", locale = null)
            UR -> W3WLanguage(code = "ur", locale = null)
            VI -> W3WLanguage(code = "vi", locale = null)
            XH -> W3WLanguage(code = "xh", locale = null)
            ZH_HANS -> W3WLanguage(code = "zh", locale = "zh_si")
            ZH_HANT_HK -> W3WLanguage(code = "zh", locale = "zh_tr")
            ZH_HANT_TW -> W3WLanguage(code = "zh", locale = "zh_tr")
            ZU -> W3WLanguage(code = "zu", locale = null)
        }
    }
}