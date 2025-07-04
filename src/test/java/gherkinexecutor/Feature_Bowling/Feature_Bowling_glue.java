package gherkinexecutor.Feature_Bowling;

import org.example.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class Feature_Bowling_glue {


    final BowlingGame game = new BowlingGame();

    void Given_rolls_are(List<List<String>> values) {
        List<List<Roll>> is = convertListToRoll(values);
        List<Roll> rolls = is.get(0);
        setRolls(rolls);

    }

    void When_roll_is(List<List<String>> values) {
        List<List<Integer>> is = convertListToInteger(values);
        Roll roll = new Roll(is.get(0).get(0));
        game.addARoll(roll);
    }

    void Then_rolls_become(List<List<String>> values) {
        List<List<Integer>> is = convertListToInteger(values);
        List<Integer> expected = is.get(0);
        List<Integer> actual = game.getRolls();
        assertEquals(expected, actual);
    }

    void Then_display_values_are(List<FrameDisplay> values) {
        System.out.println("---  " + "Then_display_values_are");
        game.convertToDisplay();
//      Used this to get value for approval testing
//        System.out.println(new ConsoleIO().createOutput(game.displayFrames));
        int index = 0;
        for (FrameDisplay value : values) {
            FrameDisplayInternal i = value.toFrameDisplayInternal();
            DisplayFrame frame = game.displayFrames[index];
            assertEquals(i.mark1.trim(), frame.mark1.trim());
            assertEquals(i.mark2.trim(), frame.mark2.trim());
            assertEquals(i.mark3.trim(), frame.mark3.trim());
            assertEquals(i.totalScore.trim(), frame.displayScore.trim());
            index++;

        }

    }

    void Then_input_control_is(List<InputControlValues> values) {
        System.out.println("---  " + "Then_input_control_is");
        for (InputControlValues value : values) {
            InputControlValuesInternal i = value.toInputControlValuesInternal();
            InputControl ic = game.getInputControl();
            assertEquals(i.frame, ic.frameNumber, "Frame Number");
            assertEquals(i.roll, ic.rollNumber, "Roll Number");
            assertEquals(i.remaining, ic.pinsRemaining, "Pins Remaining");

        }
    }


    void Then_frame_values_are(List<FrameValues> values) {
        System.out.println("---  " + "Then_frame_values_are");
        int index = 0;
        for (FrameValues value : values) {
            FrameValuesInternal i = value.toFrameValuesInternal();
            Frame frame = game.frames[index];
            System.out.println(" internal "+ i.roll1 + " " + i.roll2 + " " + i.roll3);
            System.out.println(" frame "+ frame.roll1 + " " + frame.roll2 + " " + frame.roll3);           checkAllFields(i, frame);
            index++;
        }

    }

    private static void checkAllFields(FrameValuesInternal i, Frame frame) {
        assertEquals(i.roll1, frame.roll1, "Roll 1");
        assertEquals(i.roll2, frame.roll2, " Roll 2");
        assertEquals(i.roll3, frame.roll3, " Roll 3");
        assertEquals(i.score, frame.frameScore, "Frame Score");
        assertEquals(i.totalScore, frame.totalScore, "Total Score");
    }

    void Given_frame_values_are_as_previous() {
        System.out.println("---  " + "Given_frame_values_are_as_previous");

    }

    void Then_display_is(String value) {
        System.out.println("---  " + "Then_display_is");

        String actual = new ConsoleIO().createOutput(game.convertToDisplay());
        assertEquals(value, actual);
    }

    void Then_game_complete_is(List<List<String>> values) {
        List<List<Boolean>> is = convertListToBoolean(values);
        boolean expected = is.get(0).get(0);
        boolean result = game.isComplete();
        assertEquals(expected, result);
    }

    void When_scored() {
        System.out.println("---  " + "When_scored");
        game.computeScore();
    }

    void Given_rolls_for_tenth_frame_are(List<List<String>> values) {
        List<List<Roll>> is = convertListToRoll(values);
        List<Roll> rolls = List.of(Roll.Zero, Roll.Zero, Roll.Zero,
                Roll.Zero, Roll.Zero, Roll.Zero, Roll.Zero,
                Roll.Zero, Roll.Zero, Roll.Zero, Roll.Zero,
                Roll.Zero, Roll.Zero, Roll.Zero, Roll.Zero,
                Roll.Zero, Roll.Zero, Roll.Zero);
        List<Roll> full = new ArrayList<>();
        full.addAll(rolls);
        full.addAll(is.get(0));
        setRolls(full);
    }

    void Then_Then_tenth_frame_values_are(List<FrameValues> values) {
        System.out.println("---  " + "Then_Then_tenth_frame_values_are");
        for (FrameValues value : values) {
            if (value.frame.equals("10")) {
                FrameValuesInternal i = value.toFrameValuesInternal();
                System.out.println(" internal "+ i.roll1 + " " + i.roll2 + " " + i.roll3);
                Frame f = game.frames[9];
                checkAllFields(i, f);
            }
        }
    }
    void Rule_Roll_is_between_0_and_10(List<ValueValid> values ) {
        System.out.println("---  " + "Rule_Roll_is_between_0_and_10");
        for (ValueValid value : values) {
            System.out.println(value);
            boolean expectedException = !Boolean.parseBoolean(value.valid);
            try {
                new Roll(value.value);
                if (expectedException) {
                    fail("Invalid value did not throw exception "
                            + value.value + " " + value.notes);
                }
            } catch (Exception e) {
                if (!expectedException)
                    fail("Valid value threw exception "
                            + value.value + " " + value.notes);
            }
        }
    }

    public void setRolls(List<Roll> list) {
        for (Roll roll : list){
            game.addARoll(roll);
        }
    }

    public static List<List<Boolean>> convertListToBoolean(List<List<String>> stringList) {
        List<List<Boolean>> classList = new ArrayList<>();
        for (List<String> innerList : stringList) {
            List<Boolean> innerClassList = new ArrayList<>();
            for (String s : innerList) {
                innerClassList.add(Boolean.parseBoolean(s));
            }
            classList.add(innerClassList);
        }
        return classList;
    }

    public static List<List<Integer>> convertListToInteger(List<List<String>> stringList) {
        List<List<Integer>> classList = new ArrayList<>();
        for (List<String> innerList : stringList) {
            List<Integer> innerClassList = new ArrayList<>();
            for (String s : innerList) {
                innerClassList.add(Integer.valueOf(s));
            }
            classList.add(innerClassList);
        }
        return classList;
    }

    public static List<List<Roll>> convertListToRoll(List<List<String>> stringList) {
        List<List<Roll>> classList = new ArrayList<>();
        for (List<String> innerList : stringList) {
            List<Roll> innerClassList = new ArrayList<>();
            for (String s : innerList) {
                innerClassList.add(new Roll(s));
            }
            classList.add(innerClassList);
        }
        return classList;
    }

}
