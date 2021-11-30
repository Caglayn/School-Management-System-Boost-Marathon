package com.caglayan.odevler2.menu;

public interface ISelectable {
	public void showMenuItems();
	public int getUserSelection(String message);
	public void menuLoop();
	public void endLoop();
	public void makeChoice(int choice);
}
