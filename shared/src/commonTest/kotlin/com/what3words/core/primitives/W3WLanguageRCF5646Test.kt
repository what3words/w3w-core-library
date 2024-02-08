package com.what3words.core.primitives

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class W3WLanguageRCF5646Test {

    @Test
    fun `test getLanguageCode`() {
        assertEquals("af", W3WLanguageRCF5646.AF.getLanguageCode())
        assertEquals("am", W3WLanguageRCF5646.AM.getLanguageCode())
        assertEquals("ar", W3WLanguageRCF5646.AR.getLanguageCode())
        assertEquals("bg", W3WLanguageRCF5646.BG.getLanguageCode())
        assertEquals("bn", W3WLanguageRCF5646.BN.getLanguageCode())
        assertEquals("bs", W3WLanguageRCF5646.BS_LATN.getLanguageCode())
        assertEquals("bs", W3WLanguageRCF5646.BS_CYRL.getLanguageCode())
        assertEquals("ca", W3WLanguageRCF5646.CA.getLanguageCode())
        assertEquals("cs", W3WLanguageRCF5646.CS.getLanguageCode())
        assertEquals("cy", W3WLanguageRCF5646.CY.getLanguageCode())
        assertEquals("da", W3WLanguageRCF5646.DA.getLanguageCode())
        assertEquals("de", W3WLanguageRCF5646.DE.getLanguageCode())
        assertEquals("el", W3WLanguageRCF5646.EL.getLanguageCode())
        assertEquals("en", W3WLanguageRCF5646.EN_AU.getLanguageCode())
        assertEquals("en", W3WLanguageRCF5646.EN_CA.getLanguageCode())
        assertEquals("en", W3WLanguageRCF5646.EN_GB.getLanguageCode())
        assertEquals("en", W3WLanguageRCF5646.EN_IN.getLanguageCode())
        assertEquals("es", W3WLanguageRCF5646.ES_ES.getLanguageCode())
        assertEquals("es", W3WLanguageRCF5646.ES_MX.getLanguageCode())
        assertEquals("et", W3WLanguageRCF5646.ET.getLanguageCode())
        assertEquals("fa", W3WLanguageRCF5646.FA.getLanguageCode())
        assertEquals("fi", W3WLanguageRCF5646.FI.getLanguageCode())
        assertEquals("fr", W3WLanguageRCF5646.FR_CA.getLanguageCode())
        assertEquals("fr", W3WLanguageRCF5646.FR_FR.getLanguageCode())
        assertEquals("gu", W3WLanguageRCF5646.GU.getLanguageCode())
        assertEquals("he", W3WLanguageRCF5646.HE.getLanguageCode())
        assertEquals("hi", W3WLanguageRCF5646.HI.getLanguageCode())
        assertEquals("hr", W3WLanguageRCF5646.HR.getLanguageCode())
        assertEquals("hu", W3WLanguageRCF5646.HU.getLanguageCode())
        assertEquals("id", W3WLanguageRCF5646.ID.getLanguageCode())
        assertEquals("it", W3WLanguageRCF5646.IT.getLanguageCode())
        assertEquals("ja", W3WLanguageRCF5646.JA.getLanguageCode())
        assertEquals("kk", W3WLanguageRCF5646.KK_CYRL.getLanguageCode())
        assertEquals("kk", W3WLanguageRCF5646.KK_LATN.getLanguageCode())
        assertEquals("km", W3WLanguageRCF5646.KM.getLanguageCode())
        assertEquals("kn", W3WLanguageRCF5646.KN.getLanguageCode())
        assertEquals("ko", W3WLanguageRCF5646.KO.getLanguageCode())
        assertEquals("lo", W3WLanguageRCF5646.LO.getLanguageCode())
        assertEquals("ml", W3WLanguageRCF5646.ML.getLanguageCode())
        assertEquals("mn", W3WLanguageRCF5646.MN_CYRL.getLanguageCode())
        assertEquals("mn", W3WLanguageRCF5646.MN_LATN.getLanguageCode())
        assertEquals("mr", W3WLanguageRCF5646.MR.getLanguageCode())
        assertEquals("ms", W3WLanguageRCF5646.MS.getLanguageCode())
        assertEquals("ne", W3WLanguageRCF5646.NE.getLanguageCode())
        assertEquals("nl", W3WLanguageRCF5646.NL.getLanguageCode())
        assertEquals("no", W3WLanguageRCF5646.NO.getLanguageCode())
        assertEquals("or", W3WLanguageRCF5646.OR.getLanguageCode())
        assertEquals("pa", W3WLanguageRCF5646.PA.getLanguageCode())
        assertEquals("pl", W3WLanguageRCF5646.PL.getLanguageCode())
        assertEquals("pt", W3WLanguageRCF5646.PT_BR.getLanguageCode())
        assertEquals("pt", W3WLanguageRCF5646.PT_PT.getLanguageCode())
        assertEquals("ro", W3WLanguageRCF5646.RO.getLanguageCode())
        assertEquals("ru", W3WLanguageRCF5646.RU.getLanguageCode())
        assertEquals("si", W3WLanguageRCF5646.SI.getLanguageCode())
        assertEquals("sk", W3WLanguageRCF5646.SK.getLanguageCode())
        assertEquals("sr", W3WLanguageRCF5646.SR_LATN_RS.getLanguageCode())
        assertEquals("sr", W3WLanguageRCF5646.SR_CYRL_RS.getLanguageCode())
        assertEquals("sr", W3WLanguageRCF5646.SR_LATN_ME.getLanguageCode())
        assertEquals("sr", W3WLanguageRCF5646.SR_CYRL_ME.getLanguageCode())
        assertEquals("sv", W3WLanguageRCF5646.SV.getLanguageCode())
        assertEquals("sw", W3WLanguageRCF5646.SW.getLanguageCode())
        assertEquals("ta", W3WLanguageRCF5646.TA.getLanguageCode())
        assertEquals("te", W3WLanguageRCF5646.TE.getLanguageCode())
        assertEquals("th", W3WLanguageRCF5646.TH.getLanguageCode())
        assertEquals("tr", W3WLanguageRCF5646.TR.getLanguageCode())
        assertEquals("uk", W3WLanguageRCF5646.UK.getLanguageCode())
        assertEquals("ur", W3WLanguageRCF5646.UR.getLanguageCode())
        assertEquals("vi", W3WLanguageRCF5646.VI.getLanguageCode())
        assertEquals("xh", W3WLanguageRCF5646.XH.getLanguageCode())
        assertEquals("zh", W3WLanguageRCF5646.ZH_HANS.getLanguageCode())
        assertEquals("zh", W3WLanguageRCF5646.ZH_HANT_HK.getLanguageCode())
        assertEquals("zh", W3WLanguageRCF5646.ZH_HANT_TW.getLanguageCode())
        assertEquals("zu", W3WLanguageRCF5646.ZU.getLanguageCode())
    }

    @Test
    fun `test getScriptCode`() {
        assertNull(W3WLanguageRCF5646.AF.getScriptCode())
        assertNull(W3WLanguageRCF5646.AM.getScriptCode())
        assertEquals("Latn", W3WLanguageRCF5646.BS_LATN.getScriptCode())
        assertEquals("Cyrl", W3WLanguageRCF5646.BS_CYRL.getScriptCode())
        assertNull(W3WLanguageRCF5646.CA.getScriptCode())
        assertNull(W3WLanguageRCF5646.CS.getScriptCode())
        assertNull(W3WLanguageRCF5646.CY.getScriptCode())
        assertNull(W3WLanguageRCF5646.DA.getScriptCode())
        assertNull(W3WLanguageRCF5646.DE.getScriptCode())
        assertNull(W3WLanguageRCF5646.EL.getScriptCode())
        assertNull(W3WLanguageRCF5646.EN_AU.getScriptCode())
        assertNull(W3WLanguageRCF5646.EN_CA.getScriptCode())
        assertNull(W3WLanguageRCF5646.EN_GB.getScriptCode())
        assertNull(W3WLanguageRCF5646.EN_IN.getScriptCode())
        assertNull(W3WLanguageRCF5646.ES_ES.getScriptCode())
        assertNull(W3WLanguageRCF5646.ES_MX.getScriptCode())
        assertNull(W3WLanguageRCF5646.ET.getScriptCode())
        assertNull(W3WLanguageRCF5646.FA.getScriptCode())
        assertNull(W3WLanguageRCF5646.FI.getScriptCode())
        assertNull(W3WLanguageRCF5646.FR_CA.getScriptCode())
        assertNull(W3WLanguageRCF5646.FR_FR.getScriptCode())
        assertNull(W3WLanguageRCF5646.GU.getScriptCode())
        assertNull(W3WLanguageRCF5646.HE.getScriptCode())
        assertNull(W3WLanguageRCF5646.HI.getScriptCode())
        assertNull(W3WLanguageRCF5646.HR.getScriptCode())
        assertNull(W3WLanguageRCF5646.HU.getScriptCode())
        assertNull(W3WLanguageRCF5646.ID.getScriptCode())
        assertNull(W3WLanguageRCF5646.IT.getScriptCode())
        assertNull(W3WLanguageRCF5646.JA.getScriptCode())
        assertEquals("Latn", W3WLanguageRCF5646.KK_LATN.getScriptCode())
        assertEquals("Cyrl", W3WLanguageRCF5646.KK_CYRL.getScriptCode())
        assertNull(W3WLanguageRCF5646.KM.getScriptCode())
        assertNull(W3WLanguageRCF5646.KN.getScriptCode())
        assertNull(W3WLanguageRCF5646.KO.getScriptCode())
        assertNull(W3WLanguageRCF5646.LO.getScriptCode())
        assertNull(W3WLanguageRCF5646.ML.getScriptCode())
        assertEquals("Latn", W3WLanguageRCF5646.MN_LATN.getScriptCode())
        assertEquals("Cyrl", W3WLanguageRCF5646.MN_CYRL.getScriptCode())
        assertNull(W3WLanguageRCF5646.MR.getScriptCode())
        assertNull(W3WLanguageRCF5646.MS.getScriptCode())
        assertNull(W3WLanguageRCF5646.NE.getScriptCode())
        assertNull(W3WLanguageRCF5646.NL.getScriptCode())
        assertNull(W3WLanguageRCF5646.NO.getScriptCode())
        assertNull(W3WLanguageRCF5646.OR.getScriptCode())
        assertNull(W3WLanguageRCF5646.PA.getScriptCode())
        assertNull(W3WLanguageRCF5646.PL.getScriptCode())
        assertNull(W3WLanguageRCF5646.PT_BR.getScriptCode())
        assertNull(W3WLanguageRCF5646.PT_PT.getScriptCode())
        assertNull(W3WLanguageRCF5646.RO.getScriptCode())
        assertNull(W3WLanguageRCF5646.RU.getScriptCode())
        assertNull(W3WLanguageRCF5646.SI.getScriptCode())
        assertNull(W3WLanguageRCF5646.SK.getScriptCode())
        assertEquals("Cyrl", W3WLanguageRCF5646.SR_CYRL_RS.getScriptCode())
        assertEquals("Latn", W3WLanguageRCF5646.SR_LATN_RS.getScriptCode())
        assertEquals("Latn", W3WLanguageRCF5646.SR_LATN_ME.getScriptCode())
        assertEquals("Cyrl", W3WLanguageRCF5646.SR_CYRL_ME.getScriptCode())
        assertNull(W3WLanguageRCF5646.SV.getScriptCode())
        assertNull(W3WLanguageRCF5646.SW.getScriptCode())
        assertNull(W3WLanguageRCF5646.TA.getScriptCode())
        assertNull(W3WLanguageRCF5646.TE.getScriptCode())
        assertNull(W3WLanguageRCF5646.TH.getScriptCode())
        assertNull(W3WLanguageRCF5646.TR.getScriptCode())
        assertNull(W3WLanguageRCF5646.UK.getScriptCode())
        assertNull(W3WLanguageRCF5646.UR.getScriptCode())
        assertNull(W3WLanguageRCF5646.VI.getScriptCode())
        assertNull(W3WLanguageRCF5646.XH.getScriptCode())
        assertEquals("Hans", W3WLanguageRCF5646.ZH_HANS.getScriptCode())
        assertEquals("Hant", W3WLanguageRCF5646.ZH_HANT_HK.getScriptCode())
        assertEquals("Hant", W3WLanguageRCF5646.ZH_HANT_TW.getScriptCode())
        assertNull(W3WLanguageRCF5646.ZU.getScriptCode())
    }

    @Test
    fun `test getRegionCode`() {
        assertNull(W3WLanguageRCF5646.AF.getRegionCode())
        assertNull(W3WLanguageRCF5646.AM.getRegionCode())
        assertNull(W3WLanguageRCF5646.AR.getRegionCode())
        assertNull(W3WLanguageRCF5646.BG.getRegionCode())
        assertNull(W3WLanguageRCF5646.BN.getRegionCode())
        assertNull(W3WLanguageRCF5646.BS_LATN.getRegionCode())
        assertNull(W3WLanguageRCF5646.BS_CYRL.getRegionCode())
        assertNull(W3WLanguageRCF5646.CA.getRegionCode())
        assertNull(W3WLanguageRCF5646.CS.getRegionCode())
        assertNull(W3WLanguageRCF5646.CY.getRegionCode())
        assertNull(W3WLanguageRCF5646.DA.getRegionCode())
        assertNull(W3WLanguageRCF5646.DE.getRegionCode())
        assertNull(W3WLanguageRCF5646.EL.getRegionCode())
        assertEquals("AU", W3WLanguageRCF5646.EN_AU.getRegionCode())
        assertEquals("CA", W3WLanguageRCF5646.EN_CA.getRegionCode())
        assertEquals("GB", W3WLanguageRCF5646.EN_GB.getRegionCode())
        assertEquals("IN", W3WLanguageRCF5646.EN_IN.getRegionCode())
        assertEquals("US", W3WLanguageRCF5646.EN_US.getRegionCode())
        assertEquals("ES", W3WLanguageRCF5646.ES_ES.getRegionCode())
        assertEquals("MX", W3WLanguageRCF5646.ES_MX.getRegionCode())
        assertNull(W3WLanguageRCF5646.ET.getRegionCode())
        assertNull(W3WLanguageRCF5646.FA.getRegionCode())
        assertNull(W3WLanguageRCF5646.FI.getRegionCode())
        assertEquals("CA", W3WLanguageRCF5646.FR_CA.getRegionCode())
        assertEquals("FR", W3WLanguageRCF5646.FR_FR.getRegionCode())
        assertNull(W3WLanguageRCF5646.GU.getRegionCode())
        assertNull(W3WLanguageRCF5646.HE.getRegionCode())
        assertNull(W3WLanguageRCF5646.HI.getRegionCode())
        assertNull(W3WLanguageRCF5646.HR.getRegionCode())
        assertNull(W3WLanguageRCF5646.HU.getRegionCode())
        assertNull(W3WLanguageRCF5646.ID.getRegionCode())
        assertNull(W3WLanguageRCF5646.IT.getRegionCode())
        assertNull(W3WLanguageRCF5646.JA.getRegionCode())
        assertNull(W3WLanguageRCF5646.KK_CYRL.getRegionCode())
        assertNull(W3WLanguageRCF5646.KK_LATN.getRegionCode())
        assertNull(W3WLanguageRCF5646.KM.getRegionCode())
        assertNull(W3WLanguageRCF5646.KN.getRegionCode())
        assertNull(W3WLanguageRCF5646.KO.getRegionCode())
        assertNull(W3WLanguageRCF5646.LO.getRegionCode())
        assertNull(W3WLanguageRCF5646.ML.getRegionCode())
        assertNull(W3WLanguageRCF5646.MN_CYRL.getRegionCode())
        assertNull(W3WLanguageRCF5646.MN_LATN.getRegionCode())
        assertNull(W3WLanguageRCF5646.MR.getRegionCode())
        assertNull(W3WLanguageRCF5646.MS.getRegionCode())
        assertNull(W3WLanguageRCF5646.NE.getRegionCode())
        assertNull(W3WLanguageRCF5646.NL.getRegionCode())
        assertNull(W3WLanguageRCF5646.NO.getRegionCode())
        assertNull(W3WLanguageRCF5646.OR.getRegionCode())
        assertNull(W3WLanguageRCF5646.PA.getRegionCode())
        assertNull(W3WLanguageRCF5646.PL.getRegionCode())
        assertEquals("BR", W3WLanguageRCF5646.PT_BR.getRegionCode())
        assertEquals("PT", W3WLanguageRCF5646.PT_PT.getRegionCode())
        assertNull(W3WLanguageRCF5646.RO.getRegionCode())
        assertNull(W3WLanguageRCF5646.RU.getRegionCode())
        assertNull(W3WLanguageRCF5646.SI.getRegionCode())
        assertNull(W3WLanguageRCF5646.SK.getRegionCode())
        assertEquals("RS", W3WLanguageRCF5646.SR_LATN_RS.getRegionCode())
        assertEquals("RS", W3WLanguageRCF5646.SR_CYRL_RS.getRegionCode())
        assertEquals("ME", W3WLanguageRCF5646.SR_LATN_ME.getRegionCode())
        assertEquals("ME", W3WLanguageRCF5646.SR_CYRL_ME.getRegionCode())
        assertNull(W3WLanguageRCF5646.SV.getRegionCode())
        assertNull(W3WLanguageRCF5646.SW.getRegionCode())
        assertNull(W3WLanguageRCF5646.TA.getRegionCode())
        assertNull(W3WLanguageRCF5646.TE.getRegionCode())
        assertNull(W3WLanguageRCF5646.TH.getRegionCode())
        assertNull(W3WLanguageRCF5646.TR.getRegionCode())
        assertNull(W3WLanguageRCF5646.UK.getRegionCode())
        assertNull(W3WLanguageRCF5646.UR.getRegionCode())
        assertNull(W3WLanguageRCF5646.VI.getRegionCode())
        assertNull(W3WLanguageRCF5646.XH.getRegionCode())
        assertNull(W3WLanguageRCF5646.ZH_HANS.getRegionCode())
        assertEquals("HK", W3WLanguageRCF5646.ZH_HANT_HK.getRegionCode())
        assertEquals("TW", W3WLanguageRCF5646.ZH_HANT_TW.getRegionCode())
        assertNull(W3WLanguageRCF5646.ZU.getRegionCode())
    }

    @Test
    fun testLanguageCodes() {
        W3WLanguageRCF5646.values().forEach { language ->
            assertEquals(language.code, getLanguageCode(language))
        }
    }

    private fun getLanguageCode(language: W3WLanguageRCF5646): String {
        return when (language) {
            W3WLanguageRCF5646.AF -> "af"
            W3WLanguageRCF5646.AM -> "am"
            W3WLanguageRCF5646.AR -> "ar"
            W3WLanguageRCF5646.BG -> "bg"
            W3WLanguageRCF5646.BN -> "bn"
            W3WLanguageRCF5646.BS_LATN -> "bs-Latn"
            W3WLanguageRCF5646.BS_CYRL -> "bs-Cyrl"
            W3WLanguageRCF5646.CA -> "ca"
            W3WLanguageRCF5646.CS -> "cs"
            W3WLanguageRCF5646.CY -> "cy"
            W3WLanguageRCF5646.DA -> "da"
            W3WLanguageRCF5646.DE -> "de"
            W3WLanguageRCF5646.EL -> "el"
            W3WLanguageRCF5646.EN_AU -> "en-AU"
            W3WLanguageRCF5646.EN_CA -> "en-CA"
            W3WLanguageRCF5646.EN_GB -> "en-GB"
            W3WLanguageRCF5646.EN_IN -> "en-IN"
            W3WLanguageRCF5646.EN_US -> "en-US"
            W3WLanguageRCF5646.ES_ES -> "es-ES"
            W3WLanguageRCF5646.ES_MX -> "es-MX"
            W3WLanguageRCF5646.ET -> "et"
            W3WLanguageRCF5646.FA -> "fa"
            W3WLanguageRCF5646.FI -> "fi"
            W3WLanguageRCF5646.FR_CA -> "fr-CA"
            W3WLanguageRCF5646.FR_FR -> "fr-FR"
            W3WLanguageRCF5646.GU -> "gu"
            W3WLanguageRCF5646.HE -> "he"
            W3WLanguageRCF5646.HI -> "hi"
            W3WLanguageRCF5646.HR -> "hr"
            W3WLanguageRCF5646.HU -> "hu"
            W3WLanguageRCF5646.ID -> "id"
            W3WLanguageRCF5646.IT -> "it"
            W3WLanguageRCF5646.JA -> "ja"
            W3WLanguageRCF5646.KK_CYRL -> "kk-Cyrl"
            W3WLanguageRCF5646.KK_LATN -> "kk-Latn"
            W3WLanguageRCF5646.KM -> "km"
            W3WLanguageRCF5646.KN -> "kn"
            W3WLanguageRCF5646.KO -> "ko"
            W3WLanguageRCF5646.LO -> "lo"
            W3WLanguageRCF5646.ML -> "ml"
            W3WLanguageRCF5646.MN_CYRL -> "mn-Cyrl"
            W3WLanguageRCF5646.MN_LATN -> "mn-Latn"
            W3WLanguageRCF5646.MR -> "mr"
            W3WLanguageRCF5646.MS -> "ms"
            W3WLanguageRCF5646.NE -> "ne"
            W3WLanguageRCF5646.NL -> "nl"
            W3WLanguageRCF5646.NO -> "no"
            W3WLanguageRCF5646.OR -> "or"
            W3WLanguageRCF5646.PA -> "pa"
            W3WLanguageRCF5646.PL -> "pl"
            W3WLanguageRCF5646.PT_BR -> "pt-BR"
            W3WLanguageRCF5646.PT_PT -> "pt-PT"
            W3WLanguageRCF5646.RO -> "ro"
            W3WLanguageRCF5646.RU -> "ru"
            W3WLanguageRCF5646.SI -> "si"
            W3WLanguageRCF5646.SK -> "sk"
            W3WLanguageRCF5646.SR_LATN_RS -> "sr-Latn-RS"
            W3WLanguageRCF5646.SR_CYRL_RS -> "sr-Cyrl-RS"
            W3WLanguageRCF5646.SR_LATN_ME -> "sr-Latn-ME"
            W3WLanguageRCF5646.SR_CYRL_ME -> "sr-Cyrl-ME"
            W3WLanguageRCF5646.SV -> "sv"
            W3WLanguageRCF5646.SW -> "sw"
            W3WLanguageRCF5646.TA -> "ta"
            W3WLanguageRCF5646.TE -> "te"
            W3WLanguageRCF5646.TH -> "th"
            W3WLanguageRCF5646.TR -> "tr"
            W3WLanguageRCF5646.UK -> "uk"
            W3WLanguageRCF5646.UR -> "ur"
            W3WLanguageRCF5646.VI -> "vi"
            W3WLanguageRCF5646.XH -> "xh"
            W3WLanguageRCF5646.ZH_HANS -> "zh-Hans"
            W3WLanguageRCF5646.ZH_HANT_HK -> "zh-Hant-HK"
            W3WLanguageRCF5646.ZH_HANT_TW -> "zh-Hant-TW"
            W3WLanguageRCF5646.ZU -> "zu"
        }
    }
}