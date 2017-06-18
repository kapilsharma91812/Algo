package com.kapil.anagram;

import java.util.*;

/**
 * Created by kapilsharma on 17/06/17.
 */
public class AnagramTest {
    private List<AnagramDTO> originalList;

    public AnagramTest() {
        originalList = new ArrayList();
    }

    public static void main(String args[]) {
        AnagramTest myInstance = new AnagramTest();
        setSampleData(myInstance);
        List<AnagramDTO> tmpList = cloneList(myInstance);
        sortString(tmpList);
        Collections.sort(tmpList);
        printAnagram(myInstance, tmpList);
    }

    private static void printAnagram(AnagramTest myInstance, List<AnagramDTO> tmpList) {
        for(AnagramDTO anagramDTO : tmpList) {
            System.out.println(myInstance.originalList.get(anagramDTO.getIndex()).getData() + ",");
        }
    }

    private static void sortString(List<AnagramDTO> tmpList) {
        System.out.println("*************** AnagramDTO List *******************");
        for(AnagramDTO anagramDTO : tmpList) {
            char[] chars = anagramDTO.getData().toCharArray();
            Arrays.sort(chars);
            anagramDTO.setData(new String(chars));
        }
    }


    private static List<AnagramDTO> cloneList(AnagramTest myInstance) {
        List<AnagramDTO> tmpList = new ArrayList<>(myInstance.originalList.size());
        for(AnagramDTO anagramDTO : myInstance.originalList) {
            tmpList.add(anagramDTO.clone());
        }
        return tmpList;
    }

    private static void setSampleData(AnagramTest myInstance) {
        myInstance.originalList.add(new AnagramDTO(0, "cat"));
        myInstance.originalList.add(new AnagramDTO(1, "dog"));
        myInstance.originalList.add(new AnagramDTO(2, "tac"));
        myInstance.originalList.add(new AnagramDTO(3, "god"));
        myInstance.originalList.add(new AnagramDTO(4, "act"));
    }
}
