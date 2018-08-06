package pe.andres.bairesdev.ui.home.events.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_events.*
import pe.andres.bairesdev.R
import pe.andres.bairesdev.ui.common.view.BaseViewFragment
import pe.andres.bairesdev.ui.home.events.model.EventModel
import pe.andres.bairesdev.ui.home.events.model.EventsRequest
import pe.andres.bairesdev.ui.home.events.presenter.EventsPresenter

class EventsFragment : BaseViewFragment<EventsPresenter>(), EventsView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getEvents(EventsRequest("2018-01-04", "2018-8-18", "true"))
    }

    override fun showEvents(events: List<EventModel?>?) {
        events?.let {
            rvw_events.layoutManager = LinearLayoutManager(activityContext, LinearLayoutManager.VERTICAL, false)
            rvw_events.adapter = EventAdapter(it)
            rvw_events.adapter.notifyDataSetChanged()
        }

    }

}
