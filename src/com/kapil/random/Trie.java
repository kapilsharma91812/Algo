package com.kapil.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kapilsharma on 24/06/17.
 */
public class Trie {

    class TrieNode {
        Map<Character, TrieNode> childern;
        boolean endOfWord;

        public TrieNode() {
            childern = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private void insertWord(String word) {
        insertUtil(root, word, 0);
    }

    private void insertUtil(TrieNode current, String word, int index) {
        if (index == word.length()) {
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.childern.get(ch);
        if (node == null) {
            node = new TrieNode();
            current.childern.put(ch, node);
        }
        insertUtil(node, word, index + 1);
    }

    private boolean delete(String word) {
        return deleteUtil(root, word, 0);
    }

    private boolean deleteUtil(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.childern.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.childern.get(ch);
        if (node == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = deleteUtil(current, word, index + 1);
        if (shouldDeleteCurrentNode) {
            current.childern.remove(ch);
            return current.childern.size() == 0;
        }
        return false;
    }

    private boolean search(String word) {
        return searchUtil(root, word, 0);
    }

    private boolean searchUtil(TrieNode current, String word, int index) {
        if (index == word.length()) {
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.childern.get(ch);
        if (node == null) {
            return  false;
        }
        return searchUtil(node, word, index + 1);
    }

    public static void main(String[] args) {
        Trie instance = new Trie();
        instance.insertWord("kapil");
        instance.insertWord("kamal");
        System.out.println("Search result: " + instance.search("kamal"));

    }
}
