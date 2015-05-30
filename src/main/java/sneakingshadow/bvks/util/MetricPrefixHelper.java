package sneakingshadow.bvks.util;

public class MetricPrefixHelper {

    private static String[] prefixes = {
            "",                               // | Prefix | Symbol | Exponential | Multiplier
            "K",                              // | kilo   |   k    |   10^3      | 1,000
            "M",                              // | mega   |   M    |   10^6      | 1,000,000
            "G",                              // | giga   |   G    |   10^9      | 1,000,000,000
            "T",                              // | tera   |   T    |   10^12     | 1,000,000,000,000
            "P",                              // | peta   |   P    |   10^15     | 1,000,000,000,000,000
            "E",                              // | exa    |   E    |   10^18     | 1,000,000,000,000,000,000
            "Z",                              // | zetta  |   Z    |   10^21     | 1,000,000,000,000,000,000,000
            "Y"                               // | yotta  |   Y    |   10^24     | 1,000,000,000,000,000,000,000,000
    };                                        //

    private static String compress(long num, int prefix){
        if(Long.toString(num).length() >= 4 && prefixes.length > prefix)
            return compress(num/1000, prefix+1);
        return Long.toString(num) + prefixes[prefix];
    }

    public static String compress(long num){
        return compress(num, 0);
    }

    private static String compress(int num, int prefix){
        if(Long.toString(num).length() >= 4 && prefixes.length > prefix)
            return compress(num/1000, prefix+1);
        return Long.toString(num) + prefixes[prefix];
    }

    public static String compress(int num){
        return compress(num, 0);
    }
}
