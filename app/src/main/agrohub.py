import mysql.connector
from mysql.connector import Error

def get_db_connection():
    return mysql.connector.connect(
        host='localhost',  
        user='root',  
        password='',  
        database='agrohub'
    )

def listar_consumidores():
    connection = None
    cursor = None
    try:
        connection = get_db_connection()
        cursor = connection.cursor(dictionary=True)
        cursor.callproc('sp_listar_consumidores')  # Call the stored procedure

        consumidores = []
        for result in cursor.stored_results():
            consumidores = result.fetchall()  # Fetch the results

        return consumidores  # Return the consumers

    except Error as e:
        print(f"Error: {e}")  # Print error if occurs
        return None

    finally:
        if cursor:  # Ensure cursor is closed if it was created
            cursor.close()
        if connection:  # Ensure connection is closed if it was created
            connection.close()

if __name__ == '__main__':
    consumidores = listar_consumidores()
    if consumidores is not None:
        print(consumidores)  # Print the consumers
    else:
        print("No consumers found or an error occurred.")
