package pe.andres.bairesdev.ui.home.events.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_event.view.*
import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.home.events.model.EventModel

class EventAdapter(
        private val mValues: List<EventModel?>)
    : RecyclerView.Adapter<EventAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mValues[position]?.let {
            holder.bind(it, position)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        fun bind(item: EventModel, position: Int) = with(itemView) {
            title.text = item.topLabel
            address.text = item.middleLabel
            date.text = item.bottomLabel
            quantityEvents.text = """${item?.eventCount.toString()} events"""
            Glide.with(context).load(item.image).into(image)
            favourite.setOnClickListener {

            }
        }

        override fun toString(): String {
            return super.toString() + " '" + mValues.toString()+ "'"
        }
    }
}
