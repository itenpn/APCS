public class Matrix{
    private double[][] values;
    private final int rows, columns;

    public Matrix(){
        rows = 0;
        columns = 0;
        values = new double[100][100];
    }

    public Matrix(double[][] matrix, int r, int c){
        values = matrix;
        rows = r;
        columns = c;
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public double[][] getMatrix(){
        return values;
    }

    public Matrix add(Matrix other){
        if (other.getRows() == rows && other.getColumns() == columns){
            double[][] x = new double[rows + 1][columns + 1];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    x[i][j] = values[i][j] + other.getMatrix()[i][j];
                }
            }
            return new Matrix(x, rows, columns);
        }
        return new Matrix();
    }

    public Matrix sub(Matrix other){
        if (other.getRows() == rows && other.getColumns() == columns){
            double[][] x = new double[rows + 1][columns + 1];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    x[i][j] = values[i][j] - other.getMatrix()[i][j];
                }
            }
            return new Matrix(x, rows, columns);
        }
        return new Matrix();
    }

    public Matrix mult(Matrix other){
        if (columns == other.getRows()){
            double[][] x = new double[rows + 1][other.getColumns() + 1];
            double sum;
            for (int r = 0; r < rows; r++){
                for (int i = 0; i < other.getColumns(); i++){
                    sum = 0;
                    for (int j = 0; j < columns; j++){
                        sum += values[r][j] * other.getMatrix()[j][i];
                    }
                    x[r][i] = sum;
                }
            }
            return new Matrix(x, rows, other.getColumns());
        }
        return new Matrix();
    }

    public Matrix div(Matrix other){
        return mult(other.inverse());
    }

    public Matrix inverse(){
        if (rows != columns){
            return null;
        }
        else if (rows == 2){
            double[][] x = new double[2][2];
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 2; j++){
                    x[i][j] = values[i][j] * Math.pow(-1, i + j) / det();
                }
            }
            for (int i = 0; i < 2; i++)
                for (int j = 0; j < 2; j++){
                  double temp = x[i][j];
                  x[i][j] = x[j][i];
                  x[j][i] = temp;
                }
            double temp = x[0][0];
            x[0][0] = x[1][1];
            x[1][1] = temp;
            return new Matrix(x, 2, 2);
        }
        else{
        double[][] x = new double[rows + 1][columns + 1];
          for (int i = 0; i < rows; i++){
              for (int j = 0; j < columns; j++){
                  if (rows > 2)
                    x[i][j] = minor(i,j).det() * Math.pow(-1, i + j);
                  else
                      x[i][j] = values[i][j] * Math.pow(-1, i + j);
              }
          }
          for (int i = 0; i < rows; i++){
              for (int j = 0; j < i; j++){
                  double temp = x[i][j];
                  x[i][j] = x[j][i];
                  x[j][i] = temp;
              }
          }
          for (int i = 0; i < rows; i++){
              for (int j = 0; j < columns; j++){
                  x[i][j] /= det();
              }
          }
          return new Matrix(x, rows, columns);
        }
    }

    public double det(){
        if (rows != columns){
            return 0;
        }
        else if (rows == 2 && columns == 2){
            double sum = values[0][0] * values[1][1];
            sum -= values[0][1] * values[1][0];
            return sum;
        }
        else{
            double sum = 0;
            for (int i = 0; i < columns; i++){
                if (i % 2 == 0){
                    sum += values[0][i] * (minor(0,i).det());
                }
                else {
                    sum -= values[0][i] * (minor(0, i).det());
                }
            }
            return sum;
        }
    }

    public Matrix minor(int p, int q){
        if (rows == 2 && columns == 2){
            return this;
        }
        double[][] x = new double[rows][columns];
        int currp = 0;
        int currq = 0;
        for (int i = 0; i < rows; i++){
            currq = 0;
            for (int j = 0; j < columns; j++){
                if (i != p && j != q){
                    x[currp][currq++] = values[i][j];
                }
            }
            if (i != p){
                currp++;
            }
        }
        return new Matrix(x, rows - 1, columns - 1);
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                str += String.format("%10.3f,", values[i][j]);
            }
            str += "\n";
        }
        return str;
    }
}
