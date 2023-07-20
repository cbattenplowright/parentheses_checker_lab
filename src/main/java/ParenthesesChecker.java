import java.util.ArrayList;

public class ParenthesesChecker {
    
    ArrayList<Character> testStringCharacterList = new ArrayList<>();

    public boolean checkParentheses(String testString) {

//        passesForEmptyString
        if (testString.isEmpty()) {
            return true;
        }


//        Works for MVP but bug introduced when testing extension tests due to return statement on line 37
        int numberOfParenthesesPairs = 0;

        for (int i = 0; i < testString.length(); i++) {

            Character character = testString.charAt(i);

            if (character.equals('(') || character.equals(')')) {
                testStringCharacterList.add(character);
            }
        }

        System.out.println(testStringCharacterList);

        while (testStringCharacterList.size() > 0) { // Endlessly loops when one pair is left open and never finishes
            if (testStringCharacterList.contains('(') && testStringCharacterList.contains(')')) {
                testStringCharacterList.remove(testStringCharacterList.indexOf('('));
                testStringCharacterList.remove(testStringCharacterList.indexOf(')'));
            } else if (testStringCharacterList.contains('(') || testStringCharacterList.contains(')')) {
                return false;
            }
        }
        return testStringCharacterList.size() == 0;
    }
}
