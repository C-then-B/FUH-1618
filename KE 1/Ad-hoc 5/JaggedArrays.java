public class JaggedArrays {
    public static void main(String[] args) {
        int[][] jaggedArrays = new int[10][0];
        for (int i = 0; i < jaggedArrays.length; i++) {
            jaggedArrays[i] = new int[i + 1];
            // could just do everything in here, but the uni wants separate steps..
            for (int j = 0; j < jaggedArrays[i].length; j++) {
                jaggedArrays[i][j] = j;
            }
        }

        for (int[] arr : jaggedArrays) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
