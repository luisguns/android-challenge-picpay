package com.picpay.desafio.domain.utils

sealed class Either<out S, out F> {
    data class Fail<out F> internal constructor(val value: F) : Either<Nothing, F>() {
        companion object {
            operator fun <F> invoke(f: F): Either<Nothing, F> = Fail(f)
        }
    }

    data class Success<out S> internal constructor(val value: S) : Either<S, Nothing>() {
        companion object {
            operator fun <S> invoke(s: S): Either<S, Nothing> = Success(s)
        }
    }

    companion object {
        fun <S> success(value: S): Either<S, Nothing> = Success(value)
        fun <F> fail(value: F): Either<Nothing, F> = Fail(value)
    }
}