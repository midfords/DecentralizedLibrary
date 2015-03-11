package com.comp4020.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.comp4020.adapters.FriendsArrayAdapter;
import com.comp4020.decentralized_library.DetailsActivity;
import com.comp4020.decentralized_library.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FriendsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FriendsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private ListView listView = null;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FriendsFragment.
     */
    public static FriendsFragment newInstance() {

        return new FriendsFragment();
    }

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize listView items
        View contentView = inflater.inflate(R.layout.fragment_friends, container, false);
        listView = (ListView) contentView.findViewById(R.id.friendListView);

        String[] titles = new String[] {
                "Dresden Files Skin Game",
                "Watchmen",
                "V For Vendetta",
                "V For Vendetta1",
                "V For Vendetta2",
                "V For Vendetta3",
                "V For Vendetta4",
                "V For Vendetta5",
                "V For Vendetta6"};
        String[] owners = new String[] {
                "Sean",
                "Sean",
                "Jeff",
                "Jeff",
                "Alan",
                "Alan",
                "Alan",
                "Alan",
                "Alan"};

        final FriendsArrayAdapter adapter = new FriendsArrayAdapter(contentView.getContext(),
                R.layout.row_layout_friend, titles, owners);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                view.animate().setDuration(20).alpha(0).withEndAction(
                        new Runnable() {

                            @Override
                            public void run() {

                                // Show friend's library

                            }
                        });
            }

        });

        return contentView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }

}
