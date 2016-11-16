/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cloud4Msi
 */
public class GridMatrix {
    
    private final int width;
    private final int height;
    
    private static int[][] grid;

    public GridMatrix(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[width][height];
        
        //do line, colum, subgrid
    }
    
    
    
    
}
