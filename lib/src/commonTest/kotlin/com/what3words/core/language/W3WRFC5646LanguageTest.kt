package com.what3words.core.language

import com.what3words.core.types.language.W3WRFC5646Language
import com.what3words.core.types.language.getLanguageCode
import com.what3words.core.types.language.getRegionCode
import com.what3words.core.types.language.getScriptCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class W3WRFC5646LanguageTest {

    @Test
    fun `test getLanguageCode`() {
        assertEquals("af", W3WRFC5646Language.AF.getLanguageCode())
        assertEquals("am", W3WRFC5646Language.AM.getLanguageCode())
        assertEquals("ar", W3WRFC5646Language.AR.getLanguageCode())
        assertEquals("bg", W3WRFC5646Language.BG.getLanguageCode())
        assertEquals("bn", W3WRFC5646Language.BN.getLanguageCode())
        assertEquals("bs", W3WRFC5646Language.BS_LATN.getLanguageCode())
        assertEquals("bs", W3WRFC5646Language.BS_CYRL.getLanguageCode())
        assertEquals("ca", W3WRFC5646Language.CA.getLanguageCode())
        assertEquals("cs", W3WRFC5646Language.CS.getLanguageCode())
        assertEquals("cy", W3WRFC5646Language.CY.getLanguageCode())
        assertEquals("da", W3WRFC5646Language.DA.getLanguageCode())
        assertEquals("de", W3WRFC5646Language.DE.getLanguageCode())
        assertEquals("el", W3WRFC5646Language.EL.getLanguageCode())
        assertEquals("en", W3WRFC5646Language.EN_AU.getLanguageCode())
        assertEquals("en", W3WRFC5646Language.EN_CA.getLanguageCode())
        assertEquals("en", W3WRFC5646Language.EN_GB.getLanguageCode())
        assertEquals("en", W3WRFC5646Language.EN_IN.getLanguageCode())
        assertEquals("es", W3WRFC5646Language.ES_ES.getLanguageCode())
        assertEquals("es", W3WRFC5646Language.ES_MX.getLanguageCode())
        assertEquals("et", W3WRFC5646Language.ET.getLanguageCode())
        assertEquals("fa", W3WRFC5646Language.FA.getLanguageCode())
        assertEquals("fi", W3WRFC5646Language.FI.getLanguageCode())
        assertEquals("fr", W3WRFC5646Language.FR_CA.getLanguageCode())
        assertEquals("fr", W3WRFC5646Language.FR_FR.getLanguageCode())
        assertEquals("gu", W3WRFC5646Language.GU.getLanguageCode())
        assertEquals("he", W3WRFC5646Language.HE.getLanguageCode())
        assertEquals("hi", W3WRFC5646Language.HI.getLanguageCode())
        assertEquals("hr", W3WRFC5646Language.HR.getLanguageCode())
        assertEquals("hu", W3WRFC5646Language.HU.getLanguageCode())
        assertEquals("id", W3WRFC5646Language.ID.getLanguageCode())
        assertEquals("it", W3WRFC5646Language.IT.getLanguageCode())
        assertEquals("ja", W3WRFC5646Language.JA.getLanguageCode())
        assertEquals("kk", W3WRFC5646Language.KK_CYRL.getLanguageCode())
        assertEquals("kk", W3WRFC5646Language.KK_LATN.getLanguageCode())
        assertEquals("km", W3WRFC5646Language.KM.getLanguageCode())
        assertEquals("kn", W3WRFC5646Language.KN.getLanguageCode())
        assertEquals("ko", W3WRFC5646Language.KO.getLanguageCode())
        assertEquals("lo", W3WRFC5646Language.LO.getLanguageCode())
        assertEquals("ml", W3WRFC5646Language.ML.getLanguageCode())
        assertEquals("mn", W3WRFC5646Language.MN_CYRL.getLanguageCode())
        assertEquals("mn", W3WRFC5646Language.MN_LATN.getLanguageCode())
        assertEquals("mr", W3WRFC5646Language.MR.getLanguageCode())
        assertEquals("ms", W3WRFC5646Language.MS.getLanguageCode())
        assertEquals("ne", W3WRFC5646Language.NE.getLanguageCode())
        assertEquals("nl", W3WRFC5646Language.NL.getLanguageCode())
        assertEquals("no", W3WRFC5646Language.NO.getLanguageCode())
        assertEquals("or", W3WRFC5646Language.OR.getLanguageCode())
        assertEquals("pa", W3WRFC5646Language.PA.getLanguageCode())
        assertEquals("pl", W3WRFC5646Language.PL.getLanguageCode())
        assertEquals("pt", W3WRFC5646Language.PT_BR.getLanguageCode())
        assertEquals("pt", W3WRFC5646Language.PT_PT.getLanguageCode())
        assertEquals("ro", W3WRFC5646Language.RO.getLanguageCode())
        assertEquals("ru", W3WRFC5646Language.RU.getLanguageCode())
        assertEquals("si", W3WRFC5646Language.SI.getLanguageCode())
        assertEquals("sk", W3WRFC5646Language.SK.getLanguageCode())
        assertEquals("sr", W3WRFC5646Language.SR_LATN_RS.getLanguageCode())
        assertEquals("sr", W3WRFC5646Language.SR_CYRL_RS.getLanguageCode())
        assertEquals("sr", W3WRFC5646Language.SR_LATN_ME.getLanguageCode())
        assertEquals("sr", W3WRFC5646Language.SR_CYRL_ME.getLanguageCode())
        assertEquals("sv", W3WRFC5646Language.SV.getLanguageCode())
        assertEquals("sw", W3WRFC5646Language.SW.getLanguageCode())
        assertEquals("ta", W3WRFC5646Language.TA.getLanguageCode())
        assertEquals("te", W3WRFC5646Language.TE.getLanguageCode())
        assertEquals("th", W3WRFC5646Language.TH.getLanguageCode())
        assertEquals("tr", W3WRFC5646Language.TR.getLanguageCode())
        assertEquals("uk", W3WRFC5646Language.UK.getLanguageCode())
        assertEquals("ur", W3WRFC5646Language.UR.getLanguageCode())
        assertEquals("vi", W3WRFC5646Language.VI.getLanguageCode())
        assertEquals("xh", W3WRFC5646Language.XH.getLanguageCode())
        assertEquals("zh", W3WRFC5646Language.ZH_HANS.getLanguageCode())
        assertEquals("zh", W3WRFC5646Language.ZH_HANT_HK.getLanguageCode())
        assertEquals("zh", W3WRFC5646Language.ZH_HANT_TW.getLanguageCode())
        assertEquals("zu", W3WRFC5646Language.ZU.getLanguageCode())
    }

    @Test
    fun `test getScriptCode`() {
        assertNull(W3WRFC5646Language.AF.getScriptCode())
        assertNull(W3WRFC5646Language.AM.getScriptCode())
        assertEquals("Latn", W3WRFC5646Language.BS_LATN.getScriptCode())
        assertEquals("Cyrl", W3WRFC5646Language.BS_CYRL.getScriptCode())
        assertNull(W3WRFC5646Language.CA.getScriptCode())
        assertNull(W3WRFC5646Language.CS.getScriptCode())
        assertNull(W3WRFC5646Language.CY.getScriptCode())
        assertNull(W3WRFC5646Language.DA.getScriptCode())
        assertNull(W3WRFC5646Language.DE.getScriptCode())
        assertNull(W3WRFC5646Language.EL.getScriptCode())
        assertNull(W3WRFC5646Language.EN_AU.getScriptCode())
        assertNull(W3WRFC5646Language.EN_CA.getScriptCode())
        assertNull(W3WRFC5646Language.EN_GB.getScriptCode())
        assertNull(W3WRFC5646Language.EN_IN.getScriptCode())
        assertNull(W3WRFC5646Language.ES_ES.getScriptCode())
        assertNull(W3WRFC5646Language.ES_MX.getScriptCode())
        assertNull(W3WRFC5646Language.ET.getScriptCode())
        assertNull(W3WRFC5646Language.FA.getScriptCode())
        assertNull(W3WRFC5646Language.FI.getScriptCode())
        assertNull(W3WRFC5646Language.FR_CA.getScriptCode())
        assertNull(W3WRFC5646Language.FR_FR.getScriptCode())
        assertNull(W3WRFC5646Language.GU.getScriptCode())
        assertNull(W3WRFC5646Language.HE.getScriptCode())
        assertNull(W3WRFC5646Language.HI.getScriptCode())
        assertNull(W3WRFC5646Language.HR.getScriptCode())
        assertNull(W3WRFC5646Language.HU.getScriptCode())
        assertNull(W3WRFC5646Language.ID.getScriptCode())
        assertNull(W3WRFC5646Language.IT.getScriptCode())
        assertNull(W3WRFC5646Language.JA.getScriptCode())
        assertEquals("Latn", W3WRFC5646Language.KK_LATN.getScriptCode())
        assertEquals("Cyrl", W3WRFC5646Language.KK_CYRL.getScriptCode())
        assertNull(W3WRFC5646Language.KM.getScriptCode())
        assertNull(W3WRFC5646Language.KN.getScriptCode())
        assertNull(W3WRFC5646Language.KO.getScriptCode())
        assertNull(W3WRFC5646Language.LO.getScriptCode())
        assertNull(W3WRFC5646Language.ML.getScriptCode())
        assertEquals("Latn", W3WRFC5646Language.MN_LATN.getScriptCode())
        assertEquals("Cyrl", W3WRFC5646Language.MN_CYRL.getScriptCode())
        assertNull(W3WRFC5646Language.MR.getScriptCode())
        assertNull(W3WRFC5646Language.MS.getScriptCode())
        assertNull(W3WRFC5646Language.NE.getScriptCode())
        assertNull(W3WRFC5646Language.NL.getScriptCode())
        assertNull(W3WRFC5646Language.NO.getScriptCode())
        assertNull(W3WRFC5646Language.OR.getScriptCode())
        assertNull(W3WRFC5646Language.PA.getScriptCode())
        assertNull(W3WRFC5646Language.PL.getScriptCode())
        assertNull(W3WRFC5646Language.PT_BR.getScriptCode())
        assertNull(W3WRFC5646Language.PT_PT.getScriptCode())
        assertNull(W3WRFC5646Language.RO.getScriptCode())
        assertNull(W3WRFC5646Language.RU.getScriptCode())
        assertNull(W3WRFC5646Language.SI.getScriptCode())
        assertNull(W3WRFC5646Language.SK.getScriptCode())
        assertEquals("Cyrl", W3WRFC5646Language.SR_CYRL_RS.getScriptCode())
        assertEquals("Latn", W3WRFC5646Language.SR_LATN_RS.getScriptCode())
        assertEquals("Latn", W3WRFC5646Language.SR_LATN_ME.getScriptCode())
        assertEquals("Cyrl", W3WRFC5646Language.SR_CYRL_ME.getScriptCode())
        assertNull(W3WRFC5646Language.SV.getScriptCode())
        assertNull(W3WRFC5646Language.SW.getScriptCode())
        assertNull(W3WRFC5646Language.TA.getScriptCode())
        assertNull(W3WRFC5646Language.TE.getScriptCode())
        assertNull(W3WRFC5646Language.TH.getScriptCode())
        assertNull(W3WRFC5646Language.TR.getScriptCode())
        assertNull(W3WRFC5646Language.UK.getScriptCode())
        assertNull(W3WRFC5646Language.UR.getScriptCode())
        assertNull(W3WRFC5646Language.VI.getScriptCode())
        assertNull(W3WRFC5646Language.XH.getScriptCode())
        assertEquals("Hans", W3WRFC5646Language.ZH_HANS.getScriptCode())
        assertEquals("Hant", W3WRFC5646Language.ZH_HANT_HK.getScriptCode())
        assertEquals("Hant", W3WRFC5646Language.ZH_HANT_TW.getScriptCode())
        assertNull(W3WRFC5646Language.ZU.getScriptCode())
    }

    @Test
    fun `test getRegionCode`() {
        assertNull(W3WRFC5646Language.AF.getRegionCode())
        assertNull(W3WRFC5646Language.AM.getRegionCode())
        assertNull(W3WRFC5646Language.AR.getRegionCode())
        assertNull(W3WRFC5646Language.BG.getRegionCode())
        assertNull(W3WRFC5646Language.BN.getRegionCode())
        assertNull(W3WRFC5646Language.BS_LATN.getRegionCode())
        assertNull(W3WRFC5646Language.BS_CYRL.getRegionCode())
        assertNull(W3WRFC5646Language.CA.getRegionCode())
        assertNull(W3WRFC5646Language.CS.getRegionCode())
        assertNull(W3WRFC5646Language.CY.getRegionCode())
        assertNull(W3WRFC5646Language.DA.getRegionCode())
        assertNull(W3WRFC5646Language.DE.getRegionCode())
        assertNull(W3WRFC5646Language.EL.getRegionCode())
        assertEquals("AU", W3WRFC5646Language.EN_AU.getRegionCode())
        assertEquals("CA", W3WRFC5646Language.EN_CA.getRegionCode())
        assertEquals("GB", W3WRFC5646Language.EN_GB.getRegionCode())
        assertEquals("IN", W3WRFC5646Language.EN_IN.getRegionCode())
        assertEquals("US", W3WRFC5646Language.EN_US.getRegionCode())
        assertEquals("ES", W3WRFC5646Language.ES_ES.getRegionCode())
        assertEquals("MX", W3WRFC5646Language.ES_MX.getRegionCode())
        assertNull(W3WRFC5646Language.ET.getRegionCode())
        assertNull(W3WRFC5646Language.FA.getRegionCode())
        assertNull(W3WRFC5646Language.FI.getRegionCode())
        assertEquals("CA", W3WRFC5646Language.FR_CA.getRegionCode())
        assertEquals("FR", W3WRFC5646Language.FR_FR.getRegionCode())
        assertNull(W3WRFC5646Language.GU.getRegionCode())
        assertNull(W3WRFC5646Language.HE.getRegionCode())
        assertNull(W3WRFC5646Language.HI.getRegionCode())
        assertNull(W3WRFC5646Language.HR.getRegionCode())
        assertNull(W3WRFC5646Language.HU.getRegionCode())
        assertNull(W3WRFC5646Language.ID.getRegionCode())
        assertNull(W3WRFC5646Language.IT.getRegionCode())
        assertNull(W3WRFC5646Language.JA.getRegionCode())
        assertNull(W3WRFC5646Language.KK_CYRL.getRegionCode())
        assertNull(W3WRFC5646Language.KK_LATN.getRegionCode())
        assertNull(W3WRFC5646Language.KM.getRegionCode())
        assertNull(W3WRFC5646Language.KN.getRegionCode())
        assertNull(W3WRFC5646Language.KO.getRegionCode())
        assertNull(W3WRFC5646Language.LO.getRegionCode())
        assertNull(W3WRFC5646Language.ML.getRegionCode())
        assertNull(W3WRFC5646Language.MN_CYRL.getRegionCode())
        assertNull(W3WRFC5646Language.MN_LATN.getRegionCode())
        assertNull(W3WRFC5646Language.MR.getRegionCode())
        assertNull(W3WRFC5646Language.MS.getRegionCode())
        assertNull(W3WRFC5646Language.NE.getRegionCode())
        assertNull(W3WRFC5646Language.NL.getRegionCode())
        assertNull(W3WRFC5646Language.NO.getRegionCode())
        assertNull(W3WRFC5646Language.OR.getRegionCode())
        assertNull(W3WRFC5646Language.PA.getRegionCode())
        assertNull(W3WRFC5646Language.PL.getRegionCode())
        assertEquals("BR", W3WRFC5646Language.PT_BR.getRegionCode())
        assertEquals("PT", W3WRFC5646Language.PT_PT.getRegionCode())
        assertNull(W3WRFC5646Language.RO.getRegionCode())
        assertNull(W3WRFC5646Language.RU.getRegionCode())
        assertNull(W3WRFC5646Language.SI.getRegionCode())
        assertNull(W3WRFC5646Language.SK.getRegionCode())
        assertEquals("RS", W3WRFC5646Language.SR_LATN_RS.getRegionCode())
        assertEquals("RS", W3WRFC5646Language.SR_CYRL_RS.getRegionCode())
        assertEquals("ME", W3WRFC5646Language.SR_LATN_ME.getRegionCode())
        assertEquals("ME", W3WRFC5646Language.SR_CYRL_ME.getRegionCode())
        assertNull(W3WRFC5646Language.SV.getRegionCode())
        assertNull(W3WRFC5646Language.SW.getRegionCode())
        assertNull(W3WRFC5646Language.TA.getRegionCode())
        assertNull(W3WRFC5646Language.TE.getRegionCode())
        assertNull(W3WRFC5646Language.TH.getRegionCode())
        assertNull(W3WRFC5646Language.TR.getRegionCode())
        assertNull(W3WRFC5646Language.UK.getRegionCode())
        assertNull(W3WRFC5646Language.UR.getRegionCode())
        assertNull(W3WRFC5646Language.VI.getRegionCode())
        assertNull(W3WRFC5646Language.XH.getRegionCode())
        assertNull(W3WRFC5646Language.ZH_HANS.getRegionCode())
        assertEquals("HK", W3WRFC5646Language.ZH_HANT_HK.getRegionCode())
        assertEquals("TW", W3WRFC5646Language.ZH_HANT_TW.getRegionCode())
        assertNull(W3WRFC5646Language.ZU.getRegionCode())
    }

    @Test
    fun testLanguageCodes() {
        W3WRFC5646Language.values().forEach { language ->
            assertEquals(language.code, getLanguageCode(language))
        }
    }

    private fun getLanguageCode(language: W3WRFC5646Language): String {
        return when (language) {
            W3WRFC5646Language.AF -> "af"
            W3WRFC5646Language.AM -> "am"
            W3WRFC5646Language.AR -> "ar"
            W3WRFC5646Language.BG -> "bg"
            W3WRFC5646Language.BN -> "bn"
            W3WRFC5646Language.BS_LATN -> "bs-Latn"
            W3WRFC5646Language.BS_CYRL -> "bs-Cyrl"
            W3WRFC5646Language.CA -> "ca"
            W3WRFC5646Language.CS -> "cs"
            W3WRFC5646Language.CY -> "cy"
            W3WRFC5646Language.DA -> "da"
            W3WRFC5646Language.DE -> "de"
            W3WRFC5646Language.EL -> "el"
            W3WRFC5646Language.EN_AU -> "en-AU"
            W3WRFC5646Language.EN_CA -> "en-CA"
            W3WRFC5646Language.EN_GB -> "en-GB"
            W3WRFC5646Language.EN_IN -> "en-IN"
            W3WRFC5646Language.EN_US -> "en-US"
            W3WRFC5646Language.ES_ES -> "es-ES"
            W3WRFC5646Language.ES_MX -> "es-MX"
            W3WRFC5646Language.ET -> "et"
            W3WRFC5646Language.FA -> "fa"
            W3WRFC5646Language.FI -> "fi"
            W3WRFC5646Language.FR_CA -> "fr-CA"
            W3WRFC5646Language.FR_FR -> "fr-FR"
            W3WRFC5646Language.GU -> "gu"
            W3WRFC5646Language.HE -> "he"
            W3WRFC5646Language.HI -> "hi"
            W3WRFC5646Language.HR -> "hr"
            W3WRFC5646Language.HU -> "hu"
            W3WRFC5646Language.ID -> "id"
            W3WRFC5646Language.IT -> "it"
            W3WRFC5646Language.JA -> "ja"
            W3WRFC5646Language.KK_CYRL -> "kk-Cyrl"
            W3WRFC5646Language.KK_LATN -> "kk-Latn"
            W3WRFC5646Language.KM -> "km"
            W3WRFC5646Language.KN -> "kn"
            W3WRFC5646Language.KO -> "ko"
            W3WRFC5646Language.LO -> "lo"
            W3WRFC5646Language.ML -> "ml"
            W3WRFC5646Language.MN_CYRL -> "mn-Cyrl"
            W3WRFC5646Language.MN_LATN -> "mn-Latn"
            W3WRFC5646Language.MR -> "mr"
            W3WRFC5646Language.MS -> "ms"
            W3WRFC5646Language.NE -> "ne"
            W3WRFC5646Language.NL -> "nl"
            W3WRFC5646Language.NO -> "no"
            W3WRFC5646Language.OR -> "or"
            W3WRFC5646Language.PA -> "pa"
            W3WRFC5646Language.PL -> "pl"
            W3WRFC5646Language.PT_BR -> "pt-BR"
            W3WRFC5646Language.PT_PT -> "pt-PT"
            W3WRFC5646Language.RO -> "ro"
            W3WRFC5646Language.RU -> "ru"
            W3WRFC5646Language.SI -> "si"
            W3WRFC5646Language.SK -> "sk"
            W3WRFC5646Language.SR_LATN_RS -> "sr-Latn-RS"
            W3WRFC5646Language.SR_CYRL_RS -> "sr-Cyrl-RS"
            W3WRFC5646Language.SR_LATN_ME -> "sr-Latn-ME"
            W3WRFC5646Language.SR_CYRL_ME -> "sr-Cyrl-ME"
            W3WRFC5646Language.SV -> "sv"
            W3WRFC5646Language.SW -> "sw"
            W3WRFC5646Language.TA -> "ta"
            W3WRFC5646Language.TE -> "te"
            W3WRFC5646Language.TH -> "th"
            W3WRFC5646Language.TR -> "tr"
            W3WRFC5646Language.UK -> "uk"
            W3WRFC5646Language.UR -> "ur"
            W3WRFC5646Language.VI -> "vi"
            W3WRFC5646Language.XH -> "xh"
            W3WRFC5646Language.ZH_HANS -> "zh-Hans"
            W3WRFC5646Language.ZH_HANT_HK -> "zh-Hant-HK"
            W3WRFC5646Language.ZH_HANT_TW -> "zh-Hant-TW"
            W3WRFC5646Language.ZU -> "zu"
            W3WRFC5646Language.SL -> "sl"
        }
    }
}