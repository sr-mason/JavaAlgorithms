package academy.kovalevskyi.algorithms.week2.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Trie {

  private TrieNode root = new TrieNode();
  private static final ForkJoinPool POOL = ForkJoinPool.commonPool();

  public void add(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      String tempWord = word.substring(0, i + 1);
      var node = temp.children.get(word.charAt(i));
      if (node == null) {
        node = new TrieNode();
        temp.children.put(word.charAt(i), node);
        node.value = tempWord;
      }
      temp = node;
    }
    temp.finalCharacter = true;
  }


  public boolean containsExact(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      temp = temp.children.get(word.charAt(i));
      if (temp == null) {
        return false;
      }
    }
    return temp.finalCharacter;
  }

  public int count() {
    return POOL.invoke(new WordCountAction(root));
  }

  public List<String> startsWith(String prefix) {
  var temp = root;
    for (int i = 0; i < prefix.length(); i++) {
      temp = temp.children.get(prefix.charAt(i));
      if (temp == null) {
        return new ArrayList<>();
      }
    }
    return POOL.invoke(new WordSearchAction(temp));
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.add("hi");
  }
}

