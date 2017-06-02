
import java.util.Random.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.security.MessageDigest;

public class randmst
{
    double start = System.nanoTime();
    public static void main(String[] args)
    {     
        // get arguments from command line 
        String v=args[1];
        int vert;
        vert=Integer.parseInt(v);
  
        String d=args[3];
        int dim;
        dim=Integer.parseInt(d);
        
       String run_time=args[2];
        int run;
        run=Integer.parseInt(run_time);
        
        ArrayList<Double> average_weights = new ArrayList<Double>();
        
        // while loop that keeps track of num_trials and adds it to average_weights lisst
      for (int r = 0; r < run; r++)
          
        {
          double [] [] arr = new double [dim][vert];
          ArrayList<Edge> edges = new ArrayList<Edge>();
        
          if (dim == 0)
          {

           for (int i = 0; i < vert; i ++)
           {
               for (int j = i+1; j < vert ; j++)
               {
                    
               double weight = (double)Math.random();

               
                                      
                       double weight_cutoff = Math.pow(vert, -0.955);
                       weight_cutoff = 7.29124 * weight_cutoff;
                       
                       if (weight <= weight_cutoff)
                       {
                   edges.add(new Edge(weight, i ,j));
                       }
               edges.add(new Edge(weight, i ,j));
           
               }
           }
           
       }
          
       else
       {
           for (int i = 0; i < dim; i ++)
           {
               for (int j =0; j < vert; j++)
               { 
                   arr [i][j] = (double)Math.random();
               }    
           }       
           // calculate weight
           // make arrayList of edges
           
 
           for (int i= 0; i <= vert -1; i++)
           {              
               for (int j = i +1; j <= vert - 1; j++)
               {
                   double weight = 0;
                   for (int k = 0; k <= dim -1; k++)
                       
                   {
                       weight += (arr[k][j] - arr[k][i])*(arr[k][j] - arr[k][i]);
                   }

                   weight = Math.sqrt(weight);
                   
                   
                   

                   
                   // check if weight is less than f(n)
 
                   
                   // pruning
                   
                   
                   if (dim == 2){
                       
                       double weight_cutoff = Math.pow(vert, -0.482);
                       weight_cutoff = 1.9186 * weight_cutoff;
                       
                       if (weight <= weight_cutoff)
                       {
                   edges.add(new Edge(weight, i ,j));
                       }
                   }
                   
                                      
                   if (dim == 3){
                       
                       double weight_cutoff = Math.pow(vert, -0.308);
                       weight_cutoff = 1.40514 * weight_cutoff;
                       
                       if (weight <= weight_cutoff)
                       {
                   edges.add(new Edge(weight, i ,j));
                       }
                   }
                   
                                      
                   if (dim == 4){
                       
                       double weight_cutoff = Math.pow(vert, -0.288);
                       weight_cutoff = 2.24554 * weight_cutoff;
                       
                       if (weight <= weight_cutoff)
                       {
                   edges.add(new Edge(weight, i ,j));
                       }
                   }                  
                   
                   }

               }
           }

   
        Collections.sort(edges, new CustomComparator());
   
        
   // get number of edges in original graph           
  int num_edges = edges.size();
  // vert is the number of vertices
      Subset subsets[] = new Subset[vert];
      for (int i = 0; i < vert; i ++)
      {
          subsets[i] = new Subset();
          subsets[i].parent = i;
          subsets[i].rank = 0;
      }
  

      int i = 0 ;// index used to pick new edge
      int k = 0; // to 
    ArrayList<MST> mst_edges = new ArrayList<MST>();
     
  while (mst_edges.size() < vert -1) // && edges.size() >= i)
  {
     int x = find(subsets, edges.get(i).getVert_One());
     int y = find(subsets, edges.get(i).getVert_Two());
      
      if (x != y)
      {
 
          mst_edges.add(new MST(edges.get(i).getWeight(), edges.get(i).getVert_One(), edges.get(i).getVert_Two()));
       
          union(subsets, x, y);

      }
       i++;

     
      
  }
  
  
  /*
  do pruning so keep track of max edge added 

  
  */
  
  
  
  // weight of single MST
  double final_weight = 0;
  
            for (int j = 0; j < mst_edges.size(); j ++)
        {
               final_weight +=  mst_edges.get(j).getMst_Weight();
        }
            average_weights.add(final_weight);
            arr = null;
            edges.clear();
            mst_edges.clear();
            subsets = null;
            
        }


// print average weights

double avg_weight = 0;
for (int i = 0; i < average_weights.size(); i++)
{
    avg_weight += average_weights.get(i);
}
avg_weight = avg_weight/ average_weights.size();

System.out.print(avg_weight + " " + vert + " " + run + " " + dim);
    



*/
    }
     
    
   static int  find(Subset subsets[] , int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
       
        
         return subsets[i].parent;
      
    }
    
   static void  union (Subset subsets[], int sub_1, int sub_2)
   {
       //find subset roots 
       int sub_1_root = find(subsets, sub_1);
       int sub_2_root = find(subsets, sub_2);
       
       //compare subset ranks (ranks are based on size) and update
       //their roots 
       if(subsets[sub_1_root].rank < subsets[sub_2_root].rank)
           subsets[sub_1_root].parent = sub_2_root;
       else if(subsets[sub_2_root].rank < subsets[sub_1_root].rank)
           subsets[sub_2_root].parent = sub_1_root;
       else
       {
           subsets[sub_2_root].parent = sub_1_root;
           subsets[sub_1_root].rank++;
       }
      
    }
        
        
    }
