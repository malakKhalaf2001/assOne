package ass.bzu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QAAdapter extends RecyclerView.Adapter<QAAdapter.QAViewHolder> {

    private List<QA> qalist;

    public QAAdapter(List<QA> qalist) {
        this.qalist = qalist;
    }

    @NonNull
    @Override
    public QAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new QAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QAViewHolder holder, int position) {
        QA qa = qalist.get(position);
        holder.bind(qa);
    }

    @Override
    public int getItemCount() {
        return qalist.size();
    }

    public class QAViewHolder extends RecyclerView.ViewHolder {

        private TextView tvQuestion;
        private TextView tvAnswer;

        public QAViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tv_question);
            tvAnswer = itemView.findViewById(R.id.tv_answer);
        }

        public void bind(QA qa) {
            tvQuestion.setText(qa.getQuestion());
            tvAnswer.setText(qa.getAns());
        }
    }
}
