package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java正则表达式
 * https://www.jianshu.com/p/3c076c6b2dc8
 * https://www.cnblogs.com/ggjucheng/p/3423731.html
 * https://www.w3cschool.cn/regexp/x9hf1pq9.html
 */

/**
 * 正则表达式的规则
 * 1. 任意一个字符表示匹配任意对应的字符，如a匹配a，7匹配7，-匹配-。
 * 2. []代表匹配中括号中其中任一个字符，如[abc]匹配a或b或c。
 * 3. -在中括号里面和外面代表含义不同，如在外时，就匹配-，如果在中括号内[a-b]表示匹配26个小写字母中的任一个；
 *    [a-zA-Z]匹配大小写共52个字母中任一个；[0-9]匹配十个数字中任一个。
 * 4. ^在中括号里面和外面含义不同，如在外时，就表示开头，如^7[0-9]表示匹配开头是7的，且第二位是任一数字的字符串；
 *     如果在中括号里面，表示除了这个字符之外的任意字符(包括数字，特殊字符)，如[^abc]表示匹配除去abc之外的其他任一字符。
 * 5. .表示匹配任意的字符。
 * 6. \d表示数字。
 * 7. \D表示非数字。
 * 8. \s表示由空字符组成，[ \t\n\r\x\f]。
 * 9. \S表示由非空字符组成，[^\s]。
 * 10. \w表示字母、数字、下划线，[a-zA-Z0-9_]。
 * 11. \W表示不是由字母、数字、下划线组成。
 * 12. ?: 表示出现0次或1次。
 * 13. +表示出现1次或多次。
 * 14. *表示出现0次、1次或多次。
 * 15. {n}表示出现n次。
 * 16. {n,m}表示出现n~m次。
 * 17. {n,}表示出现n次或n次以上。
 * 18. XY表示X后面跟着Y，这里X和Y分别是正则表达式的一部分。
 * 19. X|Y表示X或Y，比如"food|f"匹配的是foo（d或f），而"(food)|f"匹配的是food或f
 * 20. (X)子表达式，将X看做是一个整体。
 * 21. $: 匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与“\n”或“\r”之前的位置匹配
 * 22. (pattern): 匹配 pattern 并捕获该匹配的子表达式。可以使用 $0…$9 属性从结果“匹配”集合中检索捕获的匹配。
 *     若要匹配括号字符 ( )，请使用“\(”或者“\)”。
 * 23. (?:pattern): 匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
 *     这对于用“or”字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
 * 24. (?=pattern): 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
 *     它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?=95|98|NT|2000)' 匹配“Windows 2000”中的
 *     “Windows”，但不匹配“Windows 3.1”中的“Windows”。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随
 *     上一匹配之后，而不是在组成预测先行的字符后。
 * 25. (?!pattern): 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
 *     它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?!95|98|NT|2000)' 匹配“Windows 3.1”中的
 *    “Windows”，但不匹配“Windows 2000”中的“Windows”。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上
 *    一匹配之后，而不是在组成预测先行的字符后。
 * 26. [xyz]：字符集。匹配包含的任一字符。例如，“[abc]”匹配“plain”中的“a”。
 * 27. [^xyz]：反向字符集。匹配未包含的任何字符。例如，“[^abc]”匹配“plain”中的“p”。
 * 28. \b：匹配一个字边界，即字与空格间的位置。例如，“er\b”匹配“never”中的“er”，但不匹配“verb”中的“er”
 * 29: \B：非字边界匹配。“er\B”匹配“verb”中的“er”，但不匹配“never”中的“er”。
 * 30. \cx：匹配 x 指示的控制字符。例如，\cM 匹配 Control-M 或回车符。x 的值必须在 A-Z 或 a-z 之间。如果不是这样，则假定 c 就是“c”字符本身。
 * 31. \d：数字字符匹配。等效于 [0-9]。
 * 32. \D：非数字字符匹配。等效于 [^0-9]。
 * 33. \f：换页符匹配。等效于 \x0c 和 \cL。
 * 34. \n：换行符匹配。等效于 \x0a 和 \cJ。
 * 35. \r：匹配一个回车符。等效于 \x0d 和 \cM。
 * 36. \s：匹配任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。
 * 37. \S：匹配任何非空白字符。与 [^ \f\n\r\t\v] 等效。
 * 38. \t：制表符匹配。与 \x09 和 \cI 等效。
 * 39. \v：垂直制表符匹配。与 \x0b 和 \cK 等效。
 * 40. \w：匹配任何字类字符，包括下划线。与“[A-Za-z0-9_]”等效。
 * 41. \W：与任何非单词字符匹配。与“[^A-Za-z0-9_]”等效。
 * 42. \xn：匹配 n，此处的 n 是一个十六进制转义码。十六进制转义码必须正好是两位数长。例如，“\x41”匹配“A”。
 *    “\x041”与“\x04”&“1”等效。允许在正则表达式中使用 ASCII 代码。
 * 43. \num：匹配 num，此处的 num 是一个正整数。到捕获匹配的反向引用。例如，“(.)\1”匹配两个连续的相同字符。
 * 44. \n：标识一个八进制转义码或反向引用。如果 \n 前面至少有 n 个捕获子表达式，那么 n 是反向引用。否则，
 *     如果 n 是八进制数 (0-7)，那么 n 是八进制转义码。
 * 45. \nm：标识一个八进制转义码或反向引用。如果 \nm 前面至少有 nm 个捕获子表达式，那么 nm 是反向引用。如果 \nm 前面
 *     至少有 n 个捕获，则 n 是反向引用，后面跟有字符 m。如果两种前面的情况都不存在，则 \nm 匹配八进制值 nm，其中 n
 *     和 m 是八进制数字 (0-7)。
 * 46. \nml：当 n 是八进制数 (0-3)，m 和 l 是八进制数 (0-7) 时，匹配八进制转义码 nml。
 * 47. \\un：匹配 n，其中 n 是以四位十六进制数表示的 Unicode 字符。例如，\u00A9 匹配版权符号 (?)。
 */

public class JavaRegexDemo1 {

    /**
     * 匹配数字
     */
    private static void matchNumber() {
        String str = "8";
        //正则表达式
        String regex = "[0-9]";
        //返回匹配的结果，匹配成功就返回true，失败就返回false，此次匹配返回true。
        boolean flag = Pattern.matches(regex, str);
        System.out.println(flag);
        /**
         * Pattern.matches("\\d+", "2223"); // 返回true
         * Pattern.matches("\\d+", "2223aa"); // 返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到
         * Pattern.matches("\\d+", "22bb23"); // 返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到
         */
    }

    /**
     * matcher
     */
    private static void matcher() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("22bb23");
        m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
        Matcher m2 = p.matcher("2223");
        m2.matches();//返回true,因为\d+匹配到了整个字符串
    }

    /**
     * 匹配3个到5个字母，大小写不限，包括3和5个
     */
    private static void matcCharWithLimit() {
        // 要匹配的字符
        String str = "hello";
        // 正则表达式
        String regex = "[a-zA-Z]{3,5}";
        //输出匹配的结果, 此次匹配返回true。
        System.out.println(str.matches(regex));
    }

    /**
     * 匹配11位的电话号码，匹配规则：第一个数字是1，第二个数字是2,3,7,8中任一个，后面9位数字中不包含4
     */
    private static void matchPhoneNum() {
        // 要匹配的字符
        String str = "13656231253";
        // 正则表达式
        String regex = "1[2378][0-35-9]{9}";
        // 将给定的正则表达式编译为模式。 如果匹配需求较多，且需用同相同的regex去匹配，就可将这句写到静态模块里面，用的时候直接使用实例p
        Pattern p = Pattern.compile(regex);
        // 创建一个匹配器，匹配给定的输入与此模式。
        Matcher m = p.matcher(str);
        // 尝试将整个区域与模式进行匹配。
        boolean flag = m.matches();
        // 输出匹配结果，此次结果为true
        System.out.println(flag);
    }

    /**
     * 替换
     */
    private static void replace() {
        // 要匹配的字符
        String str = "12a6B985Ccv65";
        // 正则表达式
        String regex = "[a-zA-Z]+";
        // 正则表达式
        String regex2 = "\\d+";
        // 将字符串中英文字母替换为&符号，输出12&6&985&65
        System.out.println(str.replaceAll(regex, "&"));
        // 将字符串中单个数字或者连续的数字替换为0，输出0a0B0Ccv0
        System.out.println(str.replaceAll(regex2, "0"));
    }

    /**
     * 字符串分割
     */
    private static void spliteStr1() {
        String str = "oneTtowTthreeDfourJfive";
        String regex = "[A-Z]";
        String[] arr = str.split(regex);
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    /**
     * 字符串分割
     */
    private static void spliteStr2() {
        Pattern p = Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
    }

    /**
     * lookingAt
     * lookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
     */
    private static void lookingAt() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("22bb23");
        m.lookingAt();//返回true,因为\d+匹配到了前面的22
        Matcher m2 = p.matcher("aa2223");
        m2.lookingAt();//返回false,因为\d+不能匹配前面的aa
    }

    /**
     * find
     * find()对字符串进行匹配,匹配到的字符串可以在任何位置.
     */
    private static void find() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("22bb23");
        m.find();//返回true
        Matcher m2 = p.matcher("aa2223");
        m2.find();//返回true
        Matcher m3 = p.matcher("aa2223bb");
        m3.find();//返回true
        Matcher m4 = p.matcher("aabb");
        m4.find();//返回false
    }

    private static void startEndGroup() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaa2223bb");
        m.find(); //匹配2223
        m.start(); //返回3
        m.end(); //返回7,返回的是2223后的索引号
        m.group(); //返回2223

        Matcher m2 = p.matcher("2223bb");
        m2.lookingAt(); //匹配2223
        m2.start(); //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
        m2.end(); //返回4
        m2.group(); //返回2223

        Matcher m3 = p.matcher("2223bb");
        m3.matches();   //匹配整个字符串
//        m3.start();   //返回0
//        m3.end();   //返回6,因为matches()需要匹配所有字符串
//        m3.group();   //返回2223bb

        p = Pattern.compile("([a-z]+)(\\d+)");
        m = p.matcher("aaa2223bb");
        m.find();   //匹配aaa2223
        m.groupCount();   //返回2,因为有2组
        m.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号
        m.start(2);   //返回3
        m.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
        m.end(2);   //返回7
        m.group(1);   //返回aaa,返回第一组匹配到的子字符串
        m.group(2);   //返回2223,返回第二组匹配到的子字符串

        p = Pattern.compile("\\d+");
        m = p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        /**
         * 输出
         * 456456
         * start:6 end:12
         * 0532214
         * start:19 end:26
         * 123
         * start:36 end:39
         */
        while (m.find()) {
            System.out.println(m.group());
            System.out.print("start:" + m.start());
            System.out.println(" end:" + m.end());
        }
    }

    /**
     * 邮箱匹配
     */
    private static void emailMatch() {
        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);
    }

    public static void main(String args[]) {
        matchNumber(); // 匹配数字
        matcher(); // matcher
        matcCharWithLimit(); // 匹配3个到5个字母，大小写不限，包括3和5个
        matchPhoneNum(); // 匹配电话号码
        replace(); // 替换
        spliteStr1(); // 字符串切割
        spliteStr2(); // 字符串切割
        lookingAt(); // lookingAt
        find(); // find
        startEndGroup(); //
        emailMatch(); // 邮箱匹配
    }

}
