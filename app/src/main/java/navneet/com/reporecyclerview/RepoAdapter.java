package navneet.com.reporecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private ArrayList<RepoModel> repoModels =new ArrayList<>();
    private Context context;


    public RepoAdapter(Context context, ArrayList<RepoModel> repoModels) {
        this.repoModels = repoModels;
        this.context=context;
    }

    @NonNull
    @Override
    public RepoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_list_item,viewGroup,false);
        return new RepoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.car_name.setText(repoModels.get(i).getName());
        viewHolder.car_desc.setText(repoModels.get(i).getOwner().getLogin());

        //Picasso.get().load(carsModels.get(i).getImage()).into(viewHolder.car_image);
    }

    @Override
    public int getItemCount() {
        return repoModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private ImageView car_image;
        private TextView car_name,car_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //car_image=(ImageView)itemView.findViewById(R.id.car_image);
            car_name=(TextView) itemView.findViewById(R.id.car_name);
            car_desc=(TextView)itemView.findViewById(R.id.car_desc);
        }
    }
}
