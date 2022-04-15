package hr.msaravanj.projekt1rma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {

    private List<Holiday> holidays;
    private LayoutInflater layoutInflater;
    private ItemClickInterface itemClickInterface;

    public AdapterListe(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red_liste,parent,false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Holiday holiday = holidays.get(position);
        holder.localName.setText(holiday.getLocalName());
    }

    @Override
    public int getItemCount() {
        /*
        if (osobe==null){
            return 0;
        }else{
            return  osobe.size();
        }
        */
        return holidays == null ? 0 : holidays.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView localName;


        public Red(@NonNull View itemView) {
            super(itemView);
            localName = itemView.findViewById(R.id.localName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickInterface == null){
                return;
            }
            itemClickInterface.onItemClick(holidays.get(getAdapterPosition()));
        }
    }

    public interface ItemClickInterface{
        void onItemClick(Holiday holiday);
    }

    public void setItemClickInterface(ItemClickInterface itemClickInterface) {
        this.itemClickInterface = itemClickInterface;
    }
}
