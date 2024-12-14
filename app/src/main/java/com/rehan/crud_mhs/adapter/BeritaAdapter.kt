package com.rehan.crud_mhs.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.crud_mhs.R
import com.rehan.crud_mhs.model.ModelBerita

class BeritaAdapter
    (
    private val onClick : (ModelBerita) -> Unit
    ) : ListAdapter<ModelBerita, BeritaAdapter.ProdukViewHolder>(ProdukCallBack) {

        class ProdukViewHolder (itemView : View, val onClick : (ModelBerita) -> Unit) :

            RecyclerView.ViewHolder(itemView){
            private  val imgBerita : ImageView = itemView.findViewById(R.id.imgBerita)
            private  val title : TextView = itemView.findViewById(R.id.judulBerita)
            private  val tglBerita : TextView = itemView.findViewById(R.id.tglBerita)


            //cek produk yang saaat ini

            private var currentProduct : ModelBerita? = null

            init {
                itemView.setOnClickListener(){
                    currentProduct?.let {
                        onClick(it)
                    }
                }
            }

            fun bind(berita : ModelBerita){
                currentProduct = berita
                //set ke widget
                title.text = berita.judul
                tglBerita.text = berita.tgl_berita


                //untum menampilkan gambar
                Glide.with(itemView).load("http://192.168.57.66/beritadb/gambar_berita/"+ berita.gambar_berita).centerCrop()
                    .into(imgBerita)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_berita,parent,false
            )
            return ProdukViewHolder(view, onClick)
        }

        override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
            val berita = getItem(position)
            holder.bind(berita)

            //detail

//            holder.cardDetail.setOnClickListener{
//                val intent = Intent(holder.itemView.context,DetailProdukActivity::class.java)
//                intent.putExtra("title",produk.title)
//                intent.putExtra("description",produk.description)
//                intent.putExtra("brand",produk.brand)
//                intent.putExtra("price",produk.price)
//                intent.putExtra("thumbnail", produk.thumbnail)
//
//                holder.itemView.context.startActivity(intent)
//            }
        }

    }


    object ProdukCallBack : DiffUtil.ItemCallback<ModelBerita>() {
        override fun areItemsTheSame(oldItem: ModelBerita, newItem: ModelBerita): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ModelBerita, newItem: ModelBerita): Boolean {
            return oldItem.id == newItem.id
        }

    }
