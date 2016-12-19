import java.util.ArrayList;
import java.util.List;

public class TheClockwiseSpiral {
    private static int theElement = 1;
    private static int[][] arr;

    public static int[][] createSpiral(int N) {
        theElement = 1;
        if (N < 1) return new int[][]{};
        arr = new int[N][N];
        List<StartEndCoordinate> rowCoordinates = generateRowCoordinates(N);
        List<StartEndCoordinate> columnCoordinates = generateColumnCoordinates(N);
        int r=0;
        int c=0;
        for (int i = 0; i < 2*N-1; i++) {
            if(i%2==0){
                StartEndCoordinate s = rowCoordinates.get(r);
                fillByRow(s.columnOrRow,s.fromIndex, s.toIndex);
                r++;
            }else{
                StartEndCoordinate s = columnCoordinates.get(c);
                fillByColumns(s.columnOrRow,s.fromIndex, s.toIndex);
                c++;
            }
        }
        return arr;
    }

    private static List<StartEndCoordinate> generateColumnCoordinates(int N){
        List<StartEndCoordinate> list = new ArrayList<>();
        int j=0;
        int k=0;
        int n=N;
        for (int i = 0; i < N-1; i++) {
            if(i%2==0){
                list.add(new StartEndCoordinate(j+1,N-1-j,n-1));
                j++;
                n--;
            }else{
                list.add(new StartEndCoordinate(N-2-k,k+1,k));
                k++;
            }
        }
        return list;
    }
    private static List<StartEndCoordinate> generateRowCoordinates(int N){
        List<StartEndCoordinate> list = new ArrayList<>();
        int j=0;
        int k=0;
        int n=N;
        for (int i = 0; i < N; i++) {
            if(i%2 == 0){
                list.add(new StartEndCoordinate(j,N-1-j,j));
                j++;
            }else{
                list.add(new StartEndCoordinate(N-2-k,k,n-1));
                n--;
                k++;
            }
        }
        return list;
    }
    private static void fillByRow(int whichRow, int from, int to){
        if(from < to){
            for (int i = from ; i <=to ; i++) {
                arr[whichRow][i] = theElement++;
            }
        }else{
            for (int i = from; i >=to ; i--) {
                arr[whichRow][i] = theElement++;
            }
        }

    }
    private static void fillByColumns(int whichColumn, int from, int to){
        if(from < to){
            for (int i = from ; i <=to ; i++) {
                arr[i][whichColumn] = theElement++;
            }
        }else{
            for (int i = from; i >=to ; i--) {
                arr[i][whichColumn] = theElement++;
            }
        }
    }
    private static class StartEndCoordinate {
        int fromIndex;
        int toIndex;
        int columnOrRow;

        public StartEndCoordinate(int fromIndex, int toIndex, int cr) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.columnOrRow = cr;
        }
    }
}
