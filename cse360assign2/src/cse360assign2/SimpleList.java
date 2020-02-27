package cse360assign2;

/*
 * Class ID: 303
 * Aubrey Garcia
 * This program creates a list with functions to add and element,
 *  remove an element, return the number of elements, and
 *  search for an element in the list.
 */

public class SimpleList 
{
	/*
	 * list is the integer array
	 * count is the number of elements in the array
	 */
	private int list[];
	private int count;
	
	/*
	 * Constructor sets count to 0 and creates an array to hold 10 integers
	 */
	public SimpleList()
	{
		this.count = 0;
		list = new int[10];
	}
	
	/*
	 * Adds an integer at index 0 and re-indexes the other integers in the array
	 * @param toAdd is the integer to be added to the list
	 */
	public void add(int toAdd)
	{	
		if (count == 0)
		{
			list[0] = toAdd;
		}
		else if (count<10)
		{
			int i = count;
			while (i>=0)
			{
				list[i+1] = list[i];
				i--;
			}
			list[0] = toAdd;
		}		
		else
		{
			int i = 9;
			while (i>=0)
			{
				list[i+1] = list[i];
				i--;
			}
			list[0] = toAdd;
		}
		count++;
	}
	
	/*
	 * Removes an integer from the list and re-indexes the other integers in the array
	 * @param toRemove is the integer to be removed from the list
	 */
	public void remove (int toRemove)
	{
		int index = -1;
		int i = 0;
		while (i < count)
		{
			if (list[i] == toRemove)
			{
				index = i;
			}
			i++;
		}
		
		if (index >=0)
		{
			for (int a = index; a < (count-1); a++)
			{
				list[a] = list[a+1];
			}
			
			list[count] = 0;
			count--;
		}
	}
	
	/*
	 * @return the number of elements in the array
	 */
	public int count()
	{
		return count;
	}
	
	/*
	 * @return the list in the designated String format
	 */
	public String toString()
	{
		String str = "";
		int i = 0;
		while (i < count)
		{
			str += list[i];
			str += " ";
			i++;
		}
	
		return str;
	}
	
	/*
	 * @param toSearch is the integer to find in the array
	 * @return is the index of the integer in the array, -1 if it is not found in the array
	 */
	public int search (int toSearch)
	{
		int index = -1;
		
		for (int i = 0; i < count; i++)
		{
			if (list[i] == toSearch)
			{
				index = i;
			}
		}		
		return index;
	}
}
