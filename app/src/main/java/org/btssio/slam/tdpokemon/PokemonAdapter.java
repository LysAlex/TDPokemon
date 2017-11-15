package org.btssio.slam.tdpokemon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pokemon> pokemons;

    public PokemonAdapter(Context context, ArrayList<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    @Override
    public int getCount() {
        return pokemons.size();
    }

    @Override
    public Pokemon getItem(int position) {
        return pokemons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.pokemon_row, parent, false);
        }

        Pokemon currentPokemon = pokemons.get(position);

        final ImageView pokemonImage = (ImageView) convertView.findViewById(R.id.pokemon_image);

        try {
            pokemonImage.setImageDrawable(Drawable.createFromStream(context.getAssets().open(currentPokemon.getImage()), null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final TextView pokemonNoms = (TextView) convertView.findViewById(R.id.pokemon_noms);
        pokemonNoms.setText(currentPokemon.getNoms());

        return convertView;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
}
