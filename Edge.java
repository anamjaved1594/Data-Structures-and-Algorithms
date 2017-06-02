import java.util.*;

public class Edge// implements Comparator<Edge>
{
    
    private double weight;
    private int vert_one;
    private int vert_two;
    
    // constructor
    
    public Edge(double weight, int vert_one, int vert_two)
    {
        this.setVert_One(vert_one);
        this.setWeight(weight);
        this.setVert_Two(vert_two);
        
    }

    
    public void setWeight(double weight)
    { 
        if (weight < 0)
        {
            throw new IllegalArgumentException();
        }
        this.weight = weight;
    }
    
        public void setVert_One(int vert_one)
    { 
        if (vert_one < 0)
        {
            throw new IllegalArgumentException();
        }
        this.vert_one = vert_one;
    }
      
        public void setVert_Two(int vert_two)
    { 
        if (vert_two < 0)
        {
            throw new IllegalArgumentException();
        }
        this.vert_two = vert_two;
    }
        
        public double getWeight() {
            return this.weight;
    }
        public int getVert_One()
            {
                return this.vert_one;
            }
        
         public int getVert_Two()
            {
                return this.vert_two;
            }   

}

// pass references, not data thing...
           