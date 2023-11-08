// MatKol by <venovako@venovako.eu>

package eu.venovako.matkol;

final class Utils {

    static boolean isNonEmptyString(String s) {
        return (s != null) && !s.isEmpty();
    }

    static boolean isAlpha(char c) {
        return Character.isLetter(c) || (c == '-');
    }

    static boolean isAlpha(String s) {
        if (s == null)
            throw new IllegalArgumentException();
        final int len = s.length();
        for (int i = 0; i < len; ++i)
            if (!isAlpha(s.charAt(i)))
                return false;
        return true;
    }

}
