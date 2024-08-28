
import kotlin.math.min

class MinFall {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val dp: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
        dp[0] = matrix[0]  // Copies the first row from matrix to dp

        var ans = Int.MAX_VALUE
        for (i in 1..<matrix.size) {
            for (j in 0..<matrix[0].size) {
                var maxNo = Int.MAX_VALUE
                if (j - 1 >= 0)
                    maxNo = min(dp[i - 1][j - 1], maxNo)

                if (j + 1 < matrix[0].size)
                    maxNo = min(dp[i - 1][j + 1], maxNo)
                maxNo = min(dp[i - 1][j], maxNo)

                dp[i][j] =matrix[i][j] + maxNo

                if (i==matrix.size-1){
                    ans = min(ans,dp[i][j])
                }
            }
            println(dp.contentDeepToString())
        }
        return ans
    }
}