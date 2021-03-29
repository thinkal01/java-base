package com.note.tt;

public class _多边形 {
    private Coordinate[] coArray = null;

    public _多边形(Coordinate[] array) {
        coArray = array;
    }

    /**
     * 计算多边形边长
     *
     * @return
     */
    public double getPerimeter() {
        double perimeter = 0;

        for (int i = 0; i < coArray.length; i++) {
            int next = i + 1;

            // 如果最后一个顶点的话，需要计算和起点的距离
            if (i == coArray.length - 1) {
                next = 0;
            }

            // 计算每条边的边长
            if (coArray[i].getX() == coArray[next].getX()) {
                perimeter += Math.abs(coArray[i].getY() - coArray[next].getY());
            } else {
                perimeter += Math.abs(coArray[i].getX() - coArray[next].getX());
            }
        }

        return perimeter;
    }

    public Coordinate[] getKDivide(int k) {
        double perimeter = getPerimeter();
        double divLen = perimeter / k;
        double len = divLen;
        Coordinate[] coordinates = new Coordinate[k];
        int index = 0;

        for (int i = 0; i < coArray.length; i++) {
            int next = i + 1;
            // 如果最后一个顶点的话，需要计算和起点的距离
            if (i == coArray.length - 1) {
                next = 0;
            }

            //判断当前的边是垂直还是水平方向
            if (coArray[i].getX() == coArray[next].getX()) {
                double distance = Math.abs(coArray[i].getY() - coArray[next].getY());

                if (len < distance) {//当前边上存在k等分点，而且存在多个的情况

                    //用来记录距离当前线段起点距离
                    double base = 0;
                    while (len <= distance) {
                        if (coArray[i].getY() > coArray[next].getY()) {
                            coordinates[index] = new Coordinate(coArray[i].getX(), coArray[i].getY() - (len + base));
                        } else {
                            coordinates[index] = new Coordinate(coArray[i].getX(), coArray[i].getY() + (len + base));
                        }

                        base += len;
                        distance -= len;
                        len = divLen;
                        index++;
                    }

                    //len记录了当前边计算完k等分点后还剩余多长
                    len = divLen - distance;
                } else {
                    len -= distance;
                }
            } else { //处理垂直方向的情况
                double distance = Math.abs(coArray[i].getX() - coArray[next].getX());

                if (len < distance) {
                    double base = 0;
                    while (len <= distance) {
                        if (coArray[i].getX() > coArray[next].getX()) {
                            coordinates[index] = new Coordinate(coArray[i].getX() - (len + base), coArray[i].getY());
                        } else {
                            coordinates[index] = new Coordinate(coArray[i].getX() + (len + base), coArray[i].getY());
                        }

                        base += len;
                        index++;
                        distance -= len;
                        len = divLen;
                    }
                    len = divLen - distance;
                } else {
                    len -= distance;
                }
            }
        }

        return coordinates;
    }

}

class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double v) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}