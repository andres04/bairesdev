package pe.andres.bairesdev.ui.home.events.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        val item = mValues[position]

        with(holder.mView) {
            tag = item
            item?.let {
                holder.title.text = it.topLabel
                holder.title.text = it.topLabel
                holder.address.text = it.middleLabel
                holder.date.text = it.bottomLabel
                holder.quantityEvents.text = """${item?.eventCount.toString()} events"""
                Glide.with(context).load(it.image).into(holder.image)
            }
            }

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val title = mView.title
        val image = mView.image
        val address = mView.address
        val date = mView.date
        val quantityEvents = mView.quantityEvents

        override fun toString(): String {
            return super.toString() + " '" + mValues.toString()+ "'"
        }
    }
}
