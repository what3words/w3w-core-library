package com.what3words.core.types.options

/**
 * Sets the kind of input accepted by autosuggest
 */
enum class W3WAutosuggestInputType(val value: String) {
    /**
     * Text typed by a user, e.g.'index.home.raf'. Default setting.
     * Expects exactly two dots and no whitespace in the input.
     */
    TEXT(value = "text"),

    /**
     * JSON from Nuance VoCon Hybrid.
     * This should only be used with grammars provided by what3words ltd;
     * using other grammars will cause run-time exceptions.
     * Language detection is disabled, so lang must be set for non-English input.
     */
    VOCON_HYBRID(value = "vocon-hybrid"),

    /**
     * Text from the Nuance server at https://dictation.nuancemobility.net/NMDPAsrCmdServlet/dictation -
     * please contact Nuance before attempting to use this server.
     * Use with text from any other source is unsupported and results may not be as expected.
     * Does not handle text in languages in which words are not separated by spaces, e.g. Chinese.
     * Language detection is disabled, so lang must be set for non-English input.
     */
    NMDP_ASR(value = "nmdp-asr"),

    /**
     * Text output from speech recognition software. E.g. "index home raft".
     * This input type handles spaces between words.
     * Users should not pronounce 'dot' when speaking a what3words address.
     * Does not handle text in languages in which words are not separated by spaces, e.g. Chinese.
     * Language detection is disabled, so lang must be set.
     */
    GENERIC_VOICE(value = "generic-voice"),

    /**
     * Text from Speechmatics voice recognition.
     * Use with text from any other source is unsupported and results may not be as expected.
     * This should only be used with grammars provided by what3words ltd;
     * using other grammars will cause run-time exceptions.
     * Language detection is disabled, so language must be set.
     */
    SPEECHMATICS(value = "speechmatics");

    override fun toString(): String {
        return name
    }
}