package cse360assign2;

/*
 * Class ID: 303
 * Aubrey Garcia
 * This program creates a list with functions to add and element,
 *  remove an element, return the number of elements, search for 
 *  an element in the list, append an element, return the first 
 *  element, and return the number of elements in the list.
 */

public class SimpleList
{
	/*
	 * list is the integer array
	 * count is the number of elements in the array
	 */
	private int list[];
	private int count;
	private int temp[];
	
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
	 * If the list is full adds 50% more space to the list
	 * @param toAdd is the integer to be added to the list
	 */
	public void add(int toAdd)
	{	
		// puts toAdd to index=0
		if (count == 0)
		{
			list[0] = toAdd;
		}
		// puts toAdd in index=0 and moves all other integers over
		else if (count<list.length)
		{
			int i = count;
			while (i>=0)
			{
				list[i+1] = list[i];
				i--;
			}
			list[0] = toAdd;
		}		
		// adds 50% more space to list, puts toAdd in index=0, and moves all other integers over
		else
		{
			int i = list.length;
			temp = new int[(int)(list.length * 1.5)]; // temporary list to add more room
			
			for (int x = 1; x<list.length;x++)
			{

				temp[x] = list[i--];
			}
			
			temp[0] = toAdd;
			count++;			
			
			//restore temporary list to list
			list = new int[temp.length];		
			for (int y = 0; y < count; y++)
			{
				list[y] = temp[y];
			}
		}
	}
	
	/*
	 * Removes an integer from the list and re-indexes the other integers in the array
	 * If the list is more than 25% empty, decreases the size of the list
	 * @param toRemove is the integer to be removed from the list
	 */
	public void remove (int toRemove)
	{
		int listLength = list.length;
		int index = -1;
		int i = 0;
		
		//find index of toRemove
		while (i < count)
		{
			if (list[i] == toRemove)
			{
				index = i;
			}
			i++;
		}
		
		//remove toRemove and adjust count
		if (index >=0)
		{
			for (int a = index; a < (count-1); a++)
			{
				list[a] = list[a+1];
			}
			
			list[count] = 0;
			count--;
		}
		
		// decrease list size if necessary
		if(count < (int)(list.length * 0.75))
		{
			//create temporary list to adjust size
			temp = new int[listLength--];
			
			for (int y = 0; y < count; y++)
			{
				temp[y] = list[y];
			}
			
			// restore temporary list to list
			list = new int[temp.length];
			for (int y = 0; y < count; y++)
			{
				list[y] = temp[y];
			}
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
	 * Searches for an element in the list
	 * @param toSearch is the integer to find in the array
	 * @return is the index of the integer in the array, -1 if it is not found in the array
	 */
	public int search (int toSearch)
	{
		int index = -1;
		
		// find the index of toSearch in the array
		for (int i = 0; i < count; i++)
		{
			if (list[i] == toSearch)
			{
				index = i;
			}
		}	
		
		return index;
	}
		
	/*
	 * Appends an integer to the end of the list
	 * If the list is full, increases its size by 50%
	 * @param toAppend is the integer to be appended to the list
	 */	
	public void append(int toAppend)
	{
		//append toAppend to list
		if (count == 0)
		{
			list[0] = toAppend;
		}
		//append toAppend to list and move all other elements
		else if (count<list.length)
		{
			int i = count--;
			while (i>=0)
			{
				list[i] = list[i+1];
				i--;
			}
			list[count] = toAppend;
		}		
		//add 50% more space to list, append toAppend, and move all other elements
		else
		{
			//temporary list to adjust size
			temp = new int[(int)(list.length * 1.5)];
			
			for (int x = 0; x<list.length;x++)
			{

				temp[x] = list[x];
			}
			
			temp[count] = toAppend;
			count++;			
			
			// restore temporary list to list
			list = new int[temp.length];		
			for (int y = 0; y < count; y++)
			{
				list[y] = temp[y];
			}
		}
	}
	
	/*
	 * @return is the first element of the list
	 */
	public int first()
	{
		if (list.length == 0)
		{
			return -1;
		}
		else
		{
			return list[0];
		}
	}
	
	/*
	 * @return is the size of the list
	 */
	public int size()
	{
		return list.length;
	}
	
}
