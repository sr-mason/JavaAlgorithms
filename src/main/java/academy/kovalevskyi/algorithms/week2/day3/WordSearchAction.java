package academy.kovalevskyi.algorithms.week2.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class WordSearchAction extends RecursiveTask<List<String>> {

  private final TrieNode node;

  public WordSearchAction(TrieNode node) {
    this.node = node;
  }

  @Override
  protected List<String> compute() {
    List<WordSearchAction> subTasks = new ArrayList<>();
    List<String> words = new ArrayList<>();
    if (node.finalCharacter) {
      words.add(node.value);
    }

    for (TrieNode child : node.children.values()) {
      WordSearchAction task = new WordSearchAction(child);
      task.fork(); // запустим асинхронно
      subTasks.add(task);
    }

    for (WordSearchAction task : subTasks) {
      words.addAll(task.join()); // дождёмся выполнения задачи и прибавим результат
    }
    return words;
  }
}
