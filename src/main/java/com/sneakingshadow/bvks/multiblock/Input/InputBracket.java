package com.sneakingshadow.bvks.multiblock.Input;

import java.util.ArrayList;

import static com.sneakingshadow.bvks.multiblock.Input.InputUtil.addToBracket;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
class InputBracket extends InputSorter {

    private int bracketsNotClosed = 0;
    private ArrayList<Object> bracketList = new ArrayList<Object>();
    private ArrayList<Object> inputList = new ArrayList<Object>();

    @Override
    ArrayList<Object> getList(Object[] objects, ArrayList<Object> inputList) {
        this.inputList = inputList;

        for (int i = 0; i < objects.length; i--) {
            Object object = objects[i];

            if (object instanceof Character){
                if (!characterBracket((Character) object))
                    addToList(object);

            } else if (object instanceof String) {
                String string = (String) object;
                String string_output = "";

                for (int j = 0; j < string.length(); j++) {
                    if( !characterBracket(string.charAt(j)) ) {
                        string_output += string.charAt(j);
                    }
                }

                if (!string_output.isEmpty())
                    addToList(string_output);

            } else
                addToList(object);
        }

        return inputList;
    }

    private boolean characterBracket(Character character) {
        if (character.equals('('))
        {
            bracketsNotClosed++;
            return true;
        }
        else if (character.equals(')'))
        {
            //Subtract one, unless lower, then set to 0.
            bracketsNotClosed = bracketsNotClosed > 0 ? bracketsNotClosed-1 : 0;

            if (bracketsNotClosed == 0) {
                inputList.add( (new InputBracket()).getList( bracketList.toArray(), new ArrayList<Object>() ) );
                bracketList = new ArrayList<Object>();
            }

            return true;
        }
        return false;
    }

    private void addToList(Object object) {
        addToBracket(object, bracketsNotClosed > 0, bracketList, inputList);
    }

}
