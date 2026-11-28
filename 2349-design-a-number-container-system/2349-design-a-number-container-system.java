
class NumberContainers {

    HashMap<Integer, Integer> indexMap;
    HashMap<Integer, TreeSet<Integer>> numberMap;

    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public void change(int index, int number) {

        // Remove index from its previous number
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);

            numberMap.get(oldNumber).remove(index);
        }

        // Update index with new number
        indexMap.put(index, number);

        // Add index to the new number's TreeSet
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }

    public int find(int number) {

        if (!numberMap.containsKey(number) ||
            numberMap.get(number).isEmpty()) {
            return -1;
        }

        return numberMap.get(number).first();
    }
}
