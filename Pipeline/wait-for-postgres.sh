#!/bin/sh
host="$1"
port="$2"
shift 2
cmd="$@"

until pg_isready -h "$host" -p "$port"; do
  echo "Postgres no está listo, esperando..."
  sleep 2
done

echo "Postgres listo, lanzando la aplicación"
exec $cmd
