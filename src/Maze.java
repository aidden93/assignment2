/*
	Graphical User Interface and Maze
	Author: J.R. Dermoudy & <<INSERT YOUR NAME HERE>>
	Date: September 2013

	This file corresponds to the setup() and solve()
	routines from the sample solution.  The class is
	a frame that contains the graphical user interface.
	The frame's constructor is the equivalent to setup().
	The maze is built from a textfile (maze.txt).  The
	methods depthFirst() and breadthFirst() are the
	equivalent of solve().  These are executed via a
	button click.
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Maze extends Frame implements ActionListener
{
	private final int HORIZONTAL[]={-1,0,+1,0};	// together these two arrays represent changes to the row and column for
	private final int VERTICAL[]={0,-1,0,+1};	// the four movements: [0] is left, [1] is up, [2] is right, [3] is down
	private final boolean TRACING=false;		// display trace output?
   	private final String FILENAME="maze.txt";			// the file containing the maze

   	private Grid maze;				// the game tree used for the solution
   	private GameTree paintMe;		// the game tree with the 'current' maze as the root node
    private int goal;				// the square number of the stop square
   	private int count;				// how many squares have been visited searching for the solution?
   	private int slowDown;			// a loop counter used to slow-down the display (it needs to be defined here or else it is optimized out!)
   	private Stack dfst;				// an intermediate stack used for the depth-first search
   	private Queue bfst;				// an intermediate queue used for the breadth-first search
   	private Display window;			// the Display variable used for display
   	private BufferedReader input;	// the file variable used to refer within the program to the maze text file
   	private boolean started;		// used to indicate if the frame has been initialised
   	private boolean solvable;		// used to indicate whether the maze can be solved
   	private boolean solved;			// used to indicate whether the solution has been found
   	private Button dfs;				// a button to initiate depth-first search
   	private Button bfs;				// a button to initiate breadth-first search


   	public Maze(String a)
	/*
		Constructor method.
		Pre-condition: the given String value contains the name
					   for the frame (window) being created
		Post-condition: a frame is created showing two buttons
						and the maze to be solved (read from a
						file)
		Informally: construct the window for displaying the
					maze solution, read the maze from the file,
					and display it
	*/
   	{
      	window=new Display();

      	// create frame and window listener
      	setLayout(new FlowLayout());
      	setTitle(a);
      	setVisible(true);
      	addWindowListener(
      		new WindowAdapter()
      		{
      			public void windowClosing(WindowEvent e)
      			{
      				dispose();
      				System.exit(0);
      			}
      		}
      	);
     	setSize(300,400);

     	// create buttons
      	dfs=new Button("Solve Depth-First");
      	add(dfs);
      	dfs.addActionListener(this);
      	bfs=new Button("Solve Breadth-First");
      	add(bfs);
      	bfs.addActionListener(this);

		// construct the maze from its text file representation
      	openFile(FILENAME);
      	maze=readMaze(FILENAME);
      	closeFile(FILENAME);

      	// initialise the initial state of the program
      	solvable=true;
      	paintMe=new GameTree(maze);
      	started=true;
      	solved=false;

		// show the unsolved maze within the frame
      	setVisible(true);
      	window.setGraphics(getGraphics());
      	repaint();
   	}


	public void paint(Graphics g)
	/*
		Pre-condition: the given Graphics value is a valid
					   graphics context and corresponds to the
					   context stored within the "window"
					   instance variable
		Post-condition: the maze at the root of the tree
						referred to by the "paintMe" instance
						variable is displayed, together with a
						count of the squares investigated thus
						far if the maze has been solved.  A
						slow-down value is provided to simulate
						a slowish animation if successive mazes
						are displayed
		Informally: display the 'current' maze and the summary
					if applicable, 'pausing' briefly afterwards
	*/
	{
   		int i;

      	if (started)
      	{
      		// show the maze
           	((Grid)paintMe.getData()).showGrid(window);

           	// wait for a bit
	   		try
	   		{
	   			Thread.sleep(250);
	   		}
	   		catch (InterruptedException e)
	   		{
	   			// do nothing, just continue
	   		}

        	// show the summary if applicable
           	window.getGraphics().setColor(Color.black);
    		if (solved)
    		{
    			window.getGraphics().drawString("Maze solved in " + count + " steps.",10,350);
    		}
         	else
         	{
         		if (! solvable)
         		{
         			window.getGraphics().drawString("Maze is not solvable.",10,350);
         		}
         	}
   		}
   	}


   	public void actionPerformed(ActionEvent e)
	/*
		Pre-condition: the ActionEvent parameter indicates whether
					   the "dfs" or "bfs" buttons were pressed
		Post-condition: the maze is solved using either a depth-
						or breadth-first approach and the solution
						displayed
		Informally: solve the maze and show the solution!
	*/
   	{
   		// look for a new solution
   		solved=false;
     	count=0;
    	paintMe=new GameTree(maze);

  		if (e.getSource() == dfs) // depth-first
   		{
	    	System.out.println("Depth first traversal: ");
      		dfst = new Stack();
      		depthFirst(dfst);
  		}
   		else
   		{
			if (e.getSource() == bfs) //breadth-first
			{
				System.out.println("Breadth first traversal: ");
      			bfst = new Queue();
      			breadthFirst(bfst);
			}
       	}

       	// show the solution
   		//paint(window.getGraphics());	//sometimes necessary to avoid Display flicker
   		repaint();
     	System.out.println("Maze solved in "+ count + " steps.");
   	}


   	public void openFile(String fileName)
	/*
		Pre-condition: the file with the given name (and which
					   contains the maze) exists in the current
					   folder/directory and is a readable text
					   file
		Post-condition: the text file containing the encoded maze
						to be solved is opened for reading
		Informally: open the text file containing the maze, throw
					an exception if the file cannot be opened
	*/
   	{
      	try
      	{
		    input = new BufferedReader(new FileReader(fileName));
		}
      	catch (IOException e)
		{
		    System.out.println("Error opening " + fileName + " for loading");
		    System.exit(1);
		}
   	}


   	public void closeFile(String fileName)
	/*
		Pre-condition: a text file attached to instance variable "input"
					   is open
		Post-condition: the text file is closed
		Informally: close the text file containing the maze, throw an
					exception if it cannot be closed
	*/
	{
		try
		{
			input.close();
		}
		catch (IOException e)
		{
			System.out.println("Error closing " + fileName + " -- " + e.toString());
		}
	}


	public String getLine(String fileName)
	/*
		Pre-condition: a text file attached to instance variable "input"
					   is open and contains a validly encoded maze
		Post-condition: a non-comment line has been read from the file
						and returned
		Informally: get the next line from the file, skipping comments
					(those lines beginning with "#"), throw an exception
					if a line cannot be read from the file
	*/
	{
   		String line;

   		line=null;

   		try
   		{
   			line=input.readLine();
   			while (line.indexOf('#') == 0) // skip the comments
   			{
   				line=input.readLine();
   			}
   		}
		catch (IOException e)
		{
            System.out.println("Error in " + fileName + " data");
            System.exit(1);
		}
	   	return line;
	}


	public Grid readMaze(String fileName)
	/*
		Pre-condition: a text file attached to instance variable "input"
					   is open and contains a validly encoded maze
		Post-condition: a Grid object is created based on the maze
						encoded within the text file and installed as
						the only node of a game tree which is returned
		Informally: get the maze details out of the file and build the
					initial game tree which is returned
	*/
	{
		String hLine,vLine,line;
		Grid m;
		Square s;
		int hD,vD,n,r,c;
		Location l;
		Dimension d;

		// read the maze's dimensions
		hLine=getLine(fileName);
		vLine=getLine(fileName);
        hD=Integer.valueOf(hLine).intValue();
        vD=Integer.valueOf(vLine).intValue();
        d=new Dimension(vD,hD);

        // read the square number of the stop square
        line=getLine(fileName);
	    goal=Integer.valueOf(line).intValue();

	    // create the default maze
        m=new Grid(d,goal);

		// re-define each square from file data
        for (r=1; r<=vD; r++)
        {
        	for (c=1; c<=hD; c++)
        	{
	        	l=new Location(r,c);
				line=getLine(fileName);
	        	n=Integer.valueOf(line).intValue();
	        	if (n>=0) // non wall
	        	{
    	    		s=m.getSquare(l);
    	    		s.solidWall(false);
    	    		s.squareNumber(n);
    	    		if (n==goal) // stop square
    	    		{
    	    			s.stopSquare();
    	    		}
    	    		m.setSquare(l,s);
    	    		if (n==0) // start square
    	    		{
    	    			m.occupySquare(l,true);
     	    		}
    	    	}
    	    }
    	}

        return m;
	}


   	public void depthFirst(Stack traversal)
   	{
	/*
		Pre-condition: the current game tree (which may be empty) holds
					   the current state of maze solution, the given
					   stack (which may also be empty) holds all game
					   tree nodes which await expansion (i.e.
					   branches/forks within the maze)
		Post-condition: the stack is empty, the instance variable
						"solvable" is false, and the maze contains no
						solution; or, the current object
						holds the final solution (which is
						displayed), and the instance variable
						"solved" is true
		Informally: solve the maze through depth-first exploration
					and display the solution when (if) it is found
	*/
   	if(!paintMe.isEmpty())	{
   		Grid gameGrid = (Grid)paintMe.getData();
   		Location l = gameGrid.getLocation();
   		if(gameGrid.getGoal() == gameGrid.getSquare(l).numbered() ){
   			solved = true;
   			paint(window.getGraphics());
   	
   		}
		else{
			paint(window.getGraphics());
			for(int i = 0; i < 3; i++){
				Location l2 = new Location(gameGrid.getLocation().getColumn()+HORIZONTAL[i],gameGrid.getLocation().getRow()+VERTICAL[i]);
				if(gameGrid.validMove(l2) && !gameGrid.getSquare(l2).isOccupied() && !gameGrid.isWall(l2)){
					Grid newGrid = (Grid)gameGrid.clone();
					newGrid.occupySquare(l2, true);
					GameTree newTree = new GameTree(newGrid);
					if(i == 0){
						paintMe.setLeft(newTree);
					}
					else
					if(i == 1){
						paintMe.setForward(newTree);	
					}
					else
					{
						paintMe.setRight(newTree);
					}
					traversal.push(newTree);
				}
			}
			if(traversal.isEmpty() && !solved){
				solvable = false;
			
				
			}
			else{
				
				paintMe = (GameTree)traversal.top();
				traversal.pop();
				count++;
				depthFirst(traversal);
			}
			
		}
	
   	}

   	
   	
   	}
	public void breadthFirst(Queue traversal)
	/*
		Pre-condition: the given game tree (which may be empty) holds
					   the current state of maze solution, the given
					   queue (which may also be empty) holds all game
					   tree nodes which await expansion (i.e.
					   branches/forks within the maze)
		Post-condition: the queue is empty, the instance variable
						"solvable" is false, and the maze contains no
						solution; or, the instance variable "paintMe"
						holds the final solution (which is
						displayed), and the instance variable
						"solved" is true
		Informally: solve the maze through breadth-first exploration
					and display the solution when (if) it is found
	 */
	{
		//TODO breadthFirst

		if (!paintMe.isEmpty()) {
			traversal.add(paintMe); //add initial gametree to queue
			
			while (!traversal.isEmpty()) { //loop while queue isn't empty
				GameTree currentTree = (GameTree)traversal.front(); //get first gametree in the queue
				traversal.remove(); //remove front of queue
				
				if(!currentTree.isEmpty()) {
					Grid currentGrid = (Grid)currentTree.getData();
					Square currentSquare = currentGrid.getSquare((currentGrid.getLocation()));System.out.println(currentSquare.getLocation().getColumn()+" "+currentSquare.getLocation().getRow());
					if (!currentSquare.isStopSquare()) {
						for (int i =0; i < 3; i++) {
							Location l = new Location(currentGrid.getLocation().getColumn()+HORIZONTAL[i], currentGrid.getLocation().getRow()+VERTICAL[i]);
							System.out.println(l.getColumn()+" "+l.getRow());
							if (currentGrid.validMove(l)&& !currentGrid.getSquare(l).isOccupied() && currentGrid.isWall(l)) {
								
								
							
												
						
								//traversal.add(newTree);
								//count++;
							}
						}
					}
				}
			}
			/*
			GameTree currentTree;
			
				System.out.println(traversal.toString());
				Grid currentGrid = (Grid)traversal.front(); //get first grid in the queue
				currentTree = new GameTree(paintMe.getData());
				
				traversal.remove(); //remove top of queue

				if (currentGrid != null) {
					Square currentSquare = currentGrid.getSquare((currentGrid.getLocation()));
					if (!currentSquare.isStopSquare()) {
						for (int i =0; i <3; i++) {
							Location l = new Location(currentSquare.getLocation().getColumn()+HORIZONTAL[i], currentSquare.getLocation().getRow()+VERTICAL[i]);
							if (currentGrid.validMove(l) && !currentGrid.getSquare(l).isOccupied() && !currentGrid.isWall(l)){
								Grid newGrid = (Grid)currentGrid.clone();
								newGrid.occupySquare(l, true);
								GameTree newTree = new GameTree(newGrid, currentTree);
								if (i == 0) {
									currentTree.setLeft(newTree);
								}
								else if (i == 1) {
									currentTree.setForward(newTree);
								}
								else {
									currentTree.setRight(newTree);
								}
								traversal.add(newGrid);
							}
						}
					}
					else {
						//FOUND STOP SQUARE
						paintMe = currentTree;
					}
				}
			}*/
		}
	}
}
