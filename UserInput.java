import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserInput {

    public static void ParseCommand(List<String> wordlist) {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("take", "drop"));
        List<String> objects = new ArrayList<>(Arrays.asList("sword", "ring", "snake", "shield"));
        if (wordlist.size() > 2) {
            System.out.println("Only 2 word commands please!");

        } else {
            verb = wordlist.get(0);
            if (!commands.contains(verb)) {
                System.out.println(verb + " is not a known verb!");
            }

        }
    }

    public static List<String> WordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public static String RunCommand(String inputstr) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();

        if (lowstr.equals("")) {
            s = "You must enter a command";

        } else {
            wordlist = WordList(lowstr);
            wordlist.forEach((astr) -> System.out.println(astr));
            ParseCommand(wordlist);
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;

        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            input = in.readLine();
            output = RunCommand(input);
            System.out.println(output);
        } while (!"q".equals(input));
    }
}
