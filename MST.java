
import java.util.*;

public class MST
{
    
    private double mst_weight;
    private int mst_vert_one;
    private int mst_vert_two;
    
    // constructor
    
    public MST(double mst_weight, int mst_vert_one, int mst_vert_two)
    {
        this.setMst_Vert_One(mst_vert_one);
        this.setMst_Weight(mst_weight);
        this.setMst_Vert_Two(mst_vert_two);
        
    }
    
    // set Width
    
    public void setMst_Weight(double mst_weight)
    { 
        if (mst_weight < 0)
        {
            throw new IllegalArgumentException();
        }
        this.mst_weight = mst_weight;
    }
    
        public void setMst_Vert_One(int mst_vert_one)
    { 
        if (mst_vert_one < 0)
        {
            throw new IllegalArgumentException();
        }
        this.mst_vert_one = mst_vert_one;
    }
      
        public void setMst_Vert_Two(int mst_vert_two)
    { 
        if (mst_vert_two < 0)
        {
            throw new IllegalArgumentException();
        }
        this.mst_vert_two = mst_vert_two;
    }
        
        public double getMst_Weight() {
            return this.mst_weight;
    }
        public int getMst_Vert_One()
            {
                return this.mst_vert_one;
            }
        
         public int getMst_Vert_Two()
            {
                return this.mst_vert_two;
            }   

}