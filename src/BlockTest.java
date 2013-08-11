import junit.framework.TestCase;

public class BlockTest extends TestCase{
	
	public void testConstructor() {
		Block b = new Block(1,2,3,4);
		assertTrue(b.height() == 2);
		assertTrue(b.width() == 2);
		System.out.println(b);
	}	
	
	public void testCopy(){
		Block b3 = new Block(1,3,10, 6); // random block
		Block copyb3 = b3.clone();
		assertTrue(copyb3.height() == 9);
		assertFalse(copyb3.height()== 10);
		assertTrue(copyb3.width()==3);
		assertEquals(copyb3.toString(),"Block<(9x3)@[1,3]>");
	}
	
	public void testOne() {
		
		Block b1 = new Block(0,0,1,1); // 1x1 block
		System.out.println(b1.height());
		assertTrue(b1.height()==1);
		assertFalse(b1.width() == 3);
		assertEquals(b1.toString(),"Block<(1x1)@[0,0]>");
		
		
		Block b2 = new Block(1,1,3,3); // 2x2 block
		System.out.println(b2.height());
		assertFalse(b2.height()==5);
		assertTrue(b2.width()==2);
		assertEquals(b2.toString(),"Block<(2x2)@[1,1]>");
		
		
		Block b3 = new Block(123,122,200,182); // random block
		System.out.println(b3.height());
		assertFalse(b3.height() == 78);
		assertTrue(b3.width() == 60);
		assertEquals(b3.toString(),"Block<(77x60)@[123,122]>");
		
		/*
		Block b3 = new Block(0,0,0,0); // invalid block;
		try{
			 //invalid block
			b1.height();
			fail();
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
		*/
	}

	public void testPosition(){
		Block b = new Block(123,182,200,122); // random block
		assertTrue(b.top() == 123);
		assertTrue(b.left() == 122);
		assertTrue(b.right() == 182);
		assertTrue(b.bottom() == 200);
	}
	
	public void testInput(){
		InputSource initialBoardState = new InputSource ("tests/easy/big.search.1");
	    String line = initialBoardState.readLine();
	    while(true){
	    	line = initialBoardState.readLine();
	    	if(line == null){
	    		break;
	    	}
	    	String[] coords = line.split(" ");
	    	if(coords.length != 4){
	    		fail("Incorrect amount of numbers");
	    	}
	    	int x1 = Integer.parseInt(coords[0]);
	    	int y1 = Integer.parseInt(coords[1]);
	    	int x2 = Integer.parseInt(coords[2]);
	    	int y2 = Integer.parseInt(coords[3]);
	    	Block b = new Block(x1, y1, x2+1, y2+1);
	    	System.out.println(b);
	    }
	}
	
	
	public void testEquals(){
		Block b = new Block(123,182,200,122); // random block
		Block c = new Block(123,182,200,122);
		Block d = new Block(123,182,200,123);
		assertTrue(b.equals(c));
		assertFalse(b.equals(d));
	}
	
	public void testClone(){
		Block b = new Block(123,182,200,122); // random block
		Block bclone = b.clone();
		assertTrue(b.equals(bclone));
	}
	
	// Tests for itersecting blocks to return false.
	public void testIntersect(){
		Block b = new Block(123,182,200,122); // random block
		Block bclone = b.clone(); //same block as b.
		assertTrue(b.intersects(bclone)); //same blocks are intersected.

		Block c = new Block(1, 1, 4, 4); //they are not intersected at all.
		assertFalse(b.intersects(c));
		
		Block d = new Block(121, 182, 200, 122); //they are intersected some part.
		assertTrue(b.intersects(d));
	}
}


