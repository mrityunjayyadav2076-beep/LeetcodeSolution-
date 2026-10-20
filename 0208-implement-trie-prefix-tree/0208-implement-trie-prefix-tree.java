class Trie {
    private Trie[] children;
  
    private boolean isEndOfWord;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }
    public void insert(String word) {
        Trie currentNode = this;
      
        for (char character : word.toCharArray()) {
            int index = character - 'a';
          
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new Trie();
            }
          
            currentNode = currentNode.children[index];
        }
      
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie prefixEndNode = searchPrefix(word);
      
        return prefixEndNode != null && prefixEndNode.isEndOfWord;
    }
    public boolean startsWith(String prefix) {
        Trie prefixEndNode = searchPrefix(prefix);
      
        return prefixEndNode != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie currentNode = this;
      
        for (char character : prefix.toCharArray()) {
            int index = character - 'a';
          
            if (currentNode.children[index] == null) {
                return null;
            }
          
            currentNode = currentNode.children[index];
        }
      
        return currentNode;
    }
}

