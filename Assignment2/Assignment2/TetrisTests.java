import model.TetrisPiece;
import model.TetrisBoard;

import org.junit.jupiter.api.Test;
import sound_effects.SimpleAudio;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TetrisTests {

    //Piece tests
    @Test
    void testPiece() {

        TetrisPiece piece = new TetrisPiece("1 0  1 1  1 2  0 1");
        int [] output = piece.getLowestYVals();
        int [] target = {1,0};
        for (int i =0; i< output.length; i++) {
            assertEquals(output[i], target[i], "Error when testing lowest Y values");
        }
    }

    @Test
    void testMakeFastRotations() {
        TetrisPiece piece = new TetrisPiece(TetrisPiece.S2_STR);
        piece = TetrisPiece.makeFastRotations(piece);
        String[] target = {"0 0 0 1 1 1 1 2", "0 1 1 0 1 1 2 0", "0 0 0 1 1 1 1 2", "0 1 1 0 1 1 2 0"};
        int counter = 0;
        while(counter < 4) {
            TetrisPiece np = new TetrisPiece(target[counter]);
            piece = piece.fastRotation();
            assertTrue(np.equals(piece), "Error when testing piece equality");
            counter++;
        }

    }

    @Test
    void justPrintStuff() {
        TetrisPiece piece = new TetrisPiece(TetrisPiece.S1_STR);
        System.out.println(Arrays.toString(piece.getBody()));
        TetrisPiece curr = piece.computeNextRotation();
        while(!piece.equals(curr)) {
            System.out.println(Arrays.toString(curr.getBody()));
            curr = curr.computeNextRotation();
        }
    }

    @Test
    void justPrintStuff2() {
        TetrisBoard board = new TetrisBoard(5, 5);
        System.out.println(board);
        board.placePiece(new TetrisPiece(TetrisPiece.SQUARE_STR), 0, 0);
        System.out.println(board);
        int y = board.placementHeight(new TetrisPiece(TetrisPiece.S2_STR), 2);
        board.placePiece(new TetrisPiece(TetrisPiece.S2_STR), 2, y);
        System.out.println(board);
        TetrisPiece piece = new TetrisPiece(TetrisPiece.PYRAMID_STR);
        piece = piece.computeNextRotation();
        y = board.placementHeight(piece, 3);
        board.placePiece(piece, 3, y);
        System.out.println(board);
    }

    @Test
    void sigh() {
        TetrisBoard b1 = new TetrisBoard(5, 5);
        b1.placePiece(new TetrisPiece(TetrisPiece.PYRAMID_STR), 0, 0);
        System.out.println(b1);
        System.out.println(b1.placementHeight(new TetrisPiece(TetrisPiece.S1_STR).computeNextRotation(), 0));
        System.out.println(b1.placementHeight(new TetrisPiece(TetrisPiece.S2_STR).computeNextRotation(), 0));
        System.out.println(b1.placementHeight(new TetrisPiece(TetrisPiece.L1_STR).computeNextRotation().computeNextRotation(), 0));
        int x = b1.placePiece(new TetrisPiece(TetrisPiece.L1_STR).computeNextRotation().computeNextRotation(), 0, 4);
        System.out.println(x);
        System.out.println(b1);
        System.out.println(new TetrisPiece(TetrisPiece.L1_STR));
        System.out.println(new TetrisPiece(TetrisPiece.L1_STR).computeNextRotation().computeNextRotation());
    }

    @Test
    void testEquals() {

        TetrisPiece pieceA = new TetrisPiece("1 0  1 1  1 2  0 1");
        TetrisPiece pieceB = new TetrisPiece("1 0  1 1  1 2  0 1");
        assertTrue(pieceB.equals(pieceA), "Error when testing piece equality");
        assertTrue(pieceA.equals(pieceB), "Error when testing piece equality");

    }

    @Test
    void testPlacePiece() {

        TetrisBoard board = new TetrisBoard(10,24);
        TetrisPiece pieceA = new TetrisPiece(TetrisPiece.SQUARE_STR);

        board.commit();
        int retval = board.placePiece(pieceA, 0,0);
        assertEquals(TetrisBoard.ADD_OK,retval);

        board.commit();
        retval = board.placePiece(pieceA, 12,12); //out of bounds
        assertEquals(TetrisBoard.ADD_OUT_BOUNDS,retval);

        board.commit();
        retval = board.placePiece(pieceA, 0,0);
        assertEquals(TetrisBoard.ADD_BAD, retval);

        //fill the entire row
        retval = board.placePiece(pieceA, 2,0); board.commit();
        retval = board.placePiece(pieceA, 4,0); board.commit();
        retval = board.placePiece(pieceA, 6,0); board.commit();
        retval = board.placePiece(pieceA, 8,0);
        assertEquals(TetrisBoard.ADD_ROW_FILLED, retval);

        for (int i = 0; i < board.getWidth(); i++) {
            assertEquals(board.getGrid(i,0), true);
            assertEquals(board.getGrid(i,1), true);
            assertEquals(board.getGrid(i,2), false);
        }

    }

    @Test
    void testPlacementHeight() {
        TetrisPiece pieceA = new TetrisPiece(TetrisPiece.SQUARE_STR);
        TetrisBoard board = new TetrisBoard(10,24); board.commit();
        int retval = board.placePiece(pieceA, 0,0); board.commit();
        int x = board.placementHeight(pieceA, 0);
        assertEquals(2,x);
        retval = board.placePiece(pieceA, 0,2); board.commit();
        x = board.placementHeight(pieceA, 0);
        assertEquals(4,x);

    }

    @Test
    void testPlacementHeight2() {
        TetrisBoard board = new TetrisBoard(6,6); board.commit();
        TetrisPiece pieceA = new TetrisPiece(TetrisPiece.L1_STR);
        TetrisPiece pieceC = new TetrisPiece(TetrisPiece.STICK_STR);
        int y = board.placementHeight(pieceA, 0);
        assertEquals(y, 0);
        int retval = board.placePiece(pieceA, 0, y); board.commit();
        TetrisPiece pieceB = new TetrisPiece(TetrisPiece.L2_STR).computeNextRotation().computeNextRotation();
        y = board.placementHeight(pieceB, 1);
        assertEquals(y, 1);
        System.out.println(board);
        y = board.placementHeight(pieceC, 2);
        assertEquals(y, 0);
        board.placePiece(pieceC, 2, y);
        TetrisPiece rotate = pieceA.computeNextRotation().computeNextRotation();
        y = board.placementHeight(rotate, 2);
        board.placePiece(rotate, 2, 2);
        System.out.println(board);
        assertEquals(y, 2);
    }


    @Test
    void testClearRows() {
        TetrisBoard board = new TetrisBoard(10,24); board.commit();
        TetrisPiece pieceA = new TetrisPiece(TetrisPiece.SQUARE_STR);

        //fill two rows completely
        int retval = board.placePiece(pieceA, 0,0); board.commit();
        retval = board.placePiece(pieceA, 2,0); board.commit();
        retval = board.placePiece(pieceA, 4,0); board.commit();
        retval = board.placePiece(pieceA, 6,0); board.commit();
        retval = board.placePiece(pieceA, 8,0);

        int rcleared = board.clearRows();
        assertEquals(2, rcleared);
    }

    @Test
    void testLineFillSound() {
        SimpleAudio as = new SimpleAudio();
        as.play("Assignment2//sounds//right.wav");
        //as.playSound1("line_filled.wav");
    }
}
