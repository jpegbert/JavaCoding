package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java正则表达式
 * https://www.runoob.com/java/java-regular-expressions.html
 */
public class JavaRegexDemo {

    /**
     * 查找是否包含某一模式的子串
     */
    private static void containsSubStr() {
        String content = "I am noob from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    /**
     * 捕获组
     */
    private static void groupMatch() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    /**
     * 获取匹配的字符串的start和end
     */
    private static void getMatchStartEnd() {
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }

    /**
     * matches 和 lookingAt对比
     *
     * matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matches 要求整个序列都匹配，
     * 而lookingAt不要求。lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
     */
    private static void matchesAndLookingAt() {
        String REGEX = "foo";
        String INPUT = "fooooooooooooooooo";
        String INPUT2 = "ooooofoooooooooooo";
        Pattern pattern;
        Matcher matcher;
        Matcher matcher2;

        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);
        matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: " + REGEX); // foo
        System.out.println("Current INPUT is: " + INPUT); // fooooooooooooooooo
        System.out.println("Current INPUT2 is: " + INPUT2); // ooooofoooooooooooo

        System.out.println("lookingAt(): " + matcher.lookingAt()); // true
        System.out.println("matches(): " + matcher.matches()); // false
        System.out.println("lookingAt(): " + matcher2.lookingAt()); // false
    }

    /**
     * replaceFirst 和 replaceAll 方法对比
     *
     * replaceFirst 和 replaceAll 方法用来替换匹配正则表达式的文本。
     * 不同的是，replaceFirst 替换首次匹配，replaceAll 替换所有匹配。
     */
    private static void replaceFirstAndReplaceAll() {
        String REGEX = "dog";
        String INPUT = "The dog says meow. All dogs say meow.";
        String REPLACE = "cat";
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
//        INPUT = m.replaceAll(REPLACE); // The cat says meow. All cats say meow.
        INPUT = m.replaceFirst(REPLACE); // The cat says meow. All dogs say meow.
        System.out.println(INPUT);
    }

    /**
     * appendReplacement 和 appendTail 方法对比
     */
    private static void appendReplacementAndAppendTail() {
        String REGEX = "a*b";
        String INPUT = "aabfooaabfooabfoobkkk";
        String REPLACE = "-";
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString()); // -foo-foo-foo-kkk
    }

    public static void main(String args[]) {
        containsSubStr(); // 查找是否包含某一模式的子串
        groupMatch(); // 捕获组
        getMatchStartEnd(); // 获取匹配的字符串的start和end
        matchesAndLookingAt(); // matches 和 lookingAt对比
        replaceFirstAndReplaceAll(); // replaceFirst 和 replaceAll 方法对比
        appendReplacementAndAppendTail(); // appendReplacement 和 appendTail 方法对比
    }

}
