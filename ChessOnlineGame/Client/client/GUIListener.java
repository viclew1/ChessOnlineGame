/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.clientdatas.Model;

/**
 *
 * @author Hassenforder
 */
public interface GUIListener {

	public void notifyConnection(String name);
	
    public void updateConnection(Model model, String status);

    public void notifyPiecesLoad(Model model);
    
    public void notifyPieceMoved(Model model);

	public void notifyFinder();

	public void requestMove(int x, int y, int x2, int y2);

}
