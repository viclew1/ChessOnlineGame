/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.clientdatas;

/**
 *
 * @author Hassenforder
 */
public interface ModelListener {
    
    public void updateStatus (String status);
    
    public void updateConnection (String status);
    
    public void updateChessGame(String status);

    public void updateSearchingGame(String status);

	public void requestMove(int x, int y, int x2, int y2);

	public void updateMove(String status, int x, int y, int x2, int y2);

}
