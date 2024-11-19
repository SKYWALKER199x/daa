
// Java recursive solution for Rod cutting problem
class GFG {

    /*
     * Returns the best obtainable price for a rod of length
     * n and price[] as prices of different pieces
     */
    static int cutRod(int price[], int index, int n) {
        // base case
        // if index ==0 that means we can get n number of pieces of unit length with
        // price price[0]
        if (index == 0) {
            return n * price[0];
        }
        // if n, the size of the rod is 0 we cannot cut the rod anymore.
        if (n == 0) {
            return 0;
        }

        // At any index we have 2 options either
        // cut the rod of this length or not cut
        // it
        int notCut = cutRod(price, index - 1, n);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;
        int new_length = n - rod_length;

        // rod can be cut only if current rod length is than actual length of the rod

        if (rod_length <= n)
            // next cutting index can only be new length - 1
            cut = price[index]
                    + cutRod(price, new_length - 1, new_length);

        return Math.max(notCut, cut);
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "
                + cutRod(arr, size - 1, size));
    }
}

// This code is contributed by saikrishna padamatinti
