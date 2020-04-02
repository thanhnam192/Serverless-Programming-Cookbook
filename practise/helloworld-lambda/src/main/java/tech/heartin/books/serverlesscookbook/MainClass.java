package tech.heartin.books.serverlesscookbook;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MainClass {
    public static  void main(String[] args){
        String[] expressions = {"(a_1 + a_2) * 10"};
        Pattern pattern = Pattern.compile("(?<matrix>(?:\\[[^]]+])|(?:<[^>]+>)|(?:\\{[^}]+}))|(?<function>\\w+(?=\\())|(?<operand>\\w+)|(?<operator>[-+/*%])|(?<symbol>.)");
        for(String expression : expressions) {
            List<String> elements = new ArrayList<String>();
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
                elements.add(matcher.group());
            }
            for (String element : elements) {
                System.out.println(element);
            }
            System.out.println("\n\n\n");
        }
    }
}
